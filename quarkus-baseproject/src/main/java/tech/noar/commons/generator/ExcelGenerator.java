package tech.noar.commons.generator;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.noar.commons.annotations.excel.*;
import tech.noar.commons.enums.ExcelVersion;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExcelGenerator implements AutoCloseable {
    private static final Logger log = LoggerFactory.getLogger(ExcelGenerator.class);

    private final Workbook workbook;

    private final boolean dynamicColumn;

    private Map<String, CellStyle> mapCellStyle = new HashMap<>();

    private Map<String, Font> mapFont = new HashMap<>();

    public ExcelGenerator(@NotNull ExcelVersion excelVersion) {
        this(excelVersion, false);
    }

    public ExcelGenerator(@NotNull ExcelVersion excelVersion, boolean dynamicColumn) {
        switch (excelVersion) {
            case XLS:
                this.workbook = (Workbook) new HSSFWorkbook();
                break;
            case XLSX_STREAM:
                this.workbook = (Workbook) new SXSSFWorkbook();
                break;
            default:
                this.workbook = (Workbook) new XSSFWorkbook();
                break;
        }
        this.dynamicColumn = dynamicColumn;
    }

    public <T> void createSheet(List<T> data, Class<T> clazz) throws InvalidClassException {
        createSheet(null, data, clazz);
    }

    public <T> void createSheet(String sheetName, @NotEmpty List<T> data, @NotNull Class<T> clazz)
            throws InvalidClassException {

        if (StringUtils.isBlank(sheetName))
            sheetName = getSheetNameFromClass(clazz);

        if (this.dynamicColumn && CollectionUtils.isNotEmpty(data)) {
            Map<String, ExcelColumnMetadata> mapColumns = createMapColumnsFromData(data);
            LinkedList<ExcelColumnMetadata> columnMetadataMap = createColumnMetadataMap(mapColumns);
            Sheet sheet = this.workbook.createSheet(WorkbookUtil.createSafeSheetName(sheetName));
            createHeaderRow(sheet, columnMetadataMap);
            createDataRows(sheet, columnMetadataMap, data);
        } else {
            ExcelModelMetadata classMetadata = createModelMetadata(clazz);
            List<ExcelColumnMetadata> sortedColumn = classMetadata.getColumns();
            sortedColumn.sort(Comparator.comparingInt(ExcelColumnMetadata::getColumnIndex));
            Sheet sheet = this.workbook.createSheet(WorkbookUtil.createSafeSheetName(sheetName));
            createHeaderRow(sheet, sortedColumn);
            createDataRows(sheet, sortedColumn, data);
        }
    }

    private LinkedList<ExcelColumnMetadata> createColumnMetadataMap(Map<String, ExcelColumnMetadata> mapColumns) {
        LinkedList<ExcelColumnMetadata> excelColumnList = new LinkedList<>();
        mapColumns.forEach((key, val) -> {
            boolean isMap = val.getField().getType().isAssignableFrom(Map.class);
            List<ExcelColumnMetadata> childs = val.getChilds();
            if (CollectionUtils.isEmpty(childs) || isMap) {
                excelColumnList.add(val);
            } else if (CollectionUtils.isNotEmpty(childs)) {
                excelColumnList.addAll(val.getChilds());
            }
        });
        excelColumnList.sort(Comparator.comparingInt(ExcelColumnMetadata::getColumnIndex));
        for (int i = 0; i < excelColumnList.size(); i++) {
            ExcelColumnMetadata column = excelColumnList.get(i);
            List<ExcelColumnMetadata> columnChilds = column.getChilds();
            if (CollectionUtils.isNotEmpty(columnChilds) && column.getField().getType()
                    .isAssignableFrom(Map.class)) {
                excelColumnList.remove(i);
                excelColumnList.addAll(i, column.getChilds());
                i = i + column.getChilds().size() - 1;
            }
        }
        excelColumnList.removeIf(ExcelColumnMetadata::isMustExclude);
        return excelColumnList;
    }

    private <T> LinkedHashMap<String, ExcelColumnMetadata> createMapColumnsFromData(List<T> data) {
        LinkedHashMap<String, ExcelColumnMetadata> mapColumns = new LinkedHashMap<>();
        for (T item : data) {
            for (Class<?> clazz = item.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field classField : declaredFields) {
                    ExcelColumn annExcelColumn = classField.getAnnotation(ExcelColumn.class);
                    if (annExcelColumn != null) {
                        String key = clazz.getName() + "." + classField.getName();
                        boolean isMap = classField.getType().isAssignableFrom(Map.class);
                        ExcelColumnMetadata columnMetadata = mapColumns.get(key);
                        if (columnMetadata == null)
                            columnMetadata = ExcelColumnMetadata.createInstance(classField);
                        evaluateAndMarkMustExclude(columnMetadata, item, clazz);
                        if (!isMap) {
                            List<ExcelColumnMetadata> childList = columnMetadata.getChilds();
                            if (childList != null && CollectionUtils.isNotEmpty(childList))
                                for (ExcelColumnMetadata child : childList) {
                                    Object parentValue = getValueFromField(columnMetadata.getField(), item);
                                    if (parentValue != null)
                                        evaluateAndMarkMustExclude(child, parentValue, clazz);
                                }
                        } else {
                            Map<String, Object> valueFromField = (Map<String, Object>) getValueFromField(classField,
                                    item);
                            int childIdx = 1;
                            if (valueFromField != null) {
                                List<ExcelColumnMetadata> listColMetadataFrMap = new ArrayList<>();
                                List<ExcelColumnMetadata> currentChildList = columnMetadata.getChilds();
                                if (currentChildList != null && CollectionUtils.isNotEmpty(currentChildList))
                                    listColMetadataFrMap = currentChildList;
                                for (String mapKey : valueFromField.keySet()) {
                                    if (currentChildList != null && CollectionUtils.isNotEmpty(currentChildList)) {
                                        boolean isMapKeyExist = currentChildList.stream()
                                                .anyMatch(a -> a.getColumnName().equalsIgnoreCase(mapKey));
                                        if (isMapKeyExist)
                                            continue;
                                    }
                                    ExcelColumnMetadata colMetadataFrMap = new ExcelColumnMetadata();
                                    colMetadataFrMap.setName(key + "." + mapKey);
                                    colMetadataFrMap.setColumnName(mapKey);
                                    colMetadataFrMap.setColumnIndex(childIdx++);
                                    colMetadataFrMap.setField(classField);
                                    colMetadataFrMap.setParentField(classField);
                                    listColMetadataFrMap.add(colMetadataFrMap);
                                }
                                columnMetadata.setChilds(listColMetadataFrMap);
                            }
                        }
                        mapColumns.put(key, columnMetadata);
                    }
                }
            }
        }
        return mapColumns;
    }

    private void evaluateAndMarkMustExcludeByExpression(ExcelColumnMetadata columnMetadata, Object dataReference,
            Class<?> clazz, Exclude annotationExclude) {
        Exclude.Expression excludeExpression = annotationExclude.expression();
        String fieldName = excludeExpression.booleanField();
        String expectedValue = excludeExpression.expectedValue();
        if (StringUtils.isNotBlank(fieldName) && StringUtils.isNotBlank(expectedValue))
            try {
                Field fieldToBeEvaluate = clazz.getDeclaredField(fieldName);
                Object valueFromField = getValueFromField(fieldToBeEvaluate, dataReference);
                boolean isEqual = evaluateCondition(valueFromField + " == " + expectedValue);
                columnMetadata.setMustExclude(isEqual);
            } catch (NoSuchFieldException e) {
                log.error("Failed to evaluate Exclude expression '{} with expected value {}' .", fieldName,
                        excludeExpression);
            }
    }

    private void evaluateAndMarkMustExcludeByExclusion(ExcelColumnMetadata columnMetadata, Object dataReference,
            Exclude annotationExclude) {
        Exclude.Exclusion exclusion = annotationExclude.exclusion();
        if (exclusion != Exclude.Exclusion.NONE) {
            String val;
            Object valueFromField = getValueFromField(columnMetadata.getField(), dataReference);
            switch (exclusion) {
                case VALUE_IS_NULL:
                    if (valueFromField == null) {
                        columnMetadata.setMustExclude(true);
                        break;
                    }
                    columnMetadata.setMustExclude(false);
                    break;
                case STRING_IS_BLANK:
                    val = (String) valueFromField;
                    if (StringUtils.isBlank(val)) {
                        columnMetadata.setMustExclude(true);
                        break;
                    }
                    columnMetadata.setMustExclude(false);
                    break;
            }
        }
    }

    private void evaluateAndMarkMustExclude(@NotNull ExcelColumnMetadata columnMetadata, @NotNull Object dataReference,
            @NotNull Class<?> clazz) {
        Exclude annExclude = columnMetadata.getExclude();
        if (annExclude != null) {
            evaluateAndMarkMustExcludeByExpression(columnMetadata, dataReference, clazz, annExclude);
            evaluateAndMarkMustExcludeByExclusion(columnMetadata, dataReference, annExclude);
        }
    }

    private boolean evaluateCondition(String strCondition) {
        try {
            ScriptEngineManager engineManager = new ScriptEngineManager();
            ScriptEngine engine = engineManager.getEngineByName("javascript");
            return ((Boolean) engine.eval(strCondition)).booleanValue();
        } catch (ScriptException e) {
            log.error("Failed do evaluate condition for '{}'. caused: ", strCondition, e.getMessage());
            return false;
        }
    }

    private void createDataRows(Sheet sheet, List<ExcelColumnMetadata> sortedColumn, List<?> data) {
        int rowNumber = 1;
        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(rowNumber++);
            Object item = data.get(i);
            for (int j = 0; j < sortedColumn.size(); j++) {
                Object valueFromField;
                Cell cell = row.createCell(j);
                ExcelColumnMetadata columnMetadata = sortedColumn.get(j);
                if (columnMetadata.getParentField() != null) {
                    boolean isMap = columnMetadata.getParentField().getType().isAssignableFrom(Map.class);
                    valueFromField = getValueFromField(columnMetadata.getParentField(), item);
                    if (isMap) {
                        Map<String, Object> map = (Map<String, Object>) valueFromField;
                        if (map != null)
                            valueFromField = map.get(columnMetadata.getColumnName());
                    } else {
                        valueFromField = getValueFromField(columnMetadata.getField(), valueFromField);
                    }
                } else {
                    valueFromField = getValueFromField(columnMetadata.getField(), item);
                }
                writeCellValue(cell, valueFromField, columnMetadata);
            }
        }
    }

    private void writeCellValue(Cell cell, Object value, ExcelColumnMetadata columnMetadata) {
        CellStyle cellStyle = getOrCreateValueCellStyle(value, columnMetadata);
        Font defaultFont = getDefaultFont(12);
        cellStyle.setFont(defaultFont);
        cell.setCellStyle(cellStyle);
        String defaultValue = columnMetadata.getDefaultValue();
        if (StringUtils.isNotBlank(defaultValue))
            if (value instanceof String) {
                value = StringUtils.defaultIfBlank((String) value, defaultValue);
            } else if (value == null) {
                value = defaultValue;
            }
        if (value == null) {
            cell.setBlank();
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue(((Boolean) value).booleanValue());
        } else if (value instanceof Number) {
            cell.setCellValue(((Number) value).doubleValue());
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else if (value instanceof LocalDateTime) {
            cell.setCellValue((LocalDateTime) value);
        } else if (value instanceof Calendar) {
            cell.setCellValue((Calendar) value);
        } else if (value instanceof LocalTime) {
            String formattedLocalTime = ((LocalTime) value).format(DateTimeFormatter.ISO_LOCAL_TIME);
            cell.setCellValue(formattedLocalTime);
        } else {
            cell.setCellValue(String.valueOf(value));
        }
    }

    private Font getDefaultFont(int size) {
        if (size < 8)
            size = 10;
        String name = "DEFAULT_" + size;
        if (this.mapFont.containsKey(name))
            return this.mapFont.get(name);
        Font font = this.workbook.createFont();
        font.setFontHeightInPoints((short) size);
        this.mapFont.put(name, font);
        return font;
    }

    private CellStyle getOrCreateValueCellStyle(Object value, ExcelColumnMetadata columnMetadata) {
        String pattern = "";
        Format format = columnMetadata.getFormat();
        if (format != null)
            pattern = format.pattern();
        Class<?> fieldType = columnMetadata.getField().getType();
        String typeName = fieldType.getTypeName() + "_" + pattern;
        if (this.mapCellStyle.containsKey(typeName))
            return this.mapCellStyle.get(typeName);
        CellStyle cellStyle = this.workbook.createCellStyle();
        CreationHelper creationHelper = this.workbook.getCreationHelper();
        if (fieldType != String.class) {
            if (fieldType == Date.class || fieldType == LocalDateTime.class || fieldType == Calendar.class) {
                pattern = StringUtils.defaultIfBlank(pattern, "yyyy-mm-dd HH:mm:ss");
            } else if (fieldType.getSuperclass() != null && fieldType.getSuperclass() == Number.class) {
                if ((value instanceof Double || value instanceof Float) && StringUtils.isBlank(pattern))
                    pattern = "#,##0.00";
            } else if (fieldType == LocalDate.class) {
                pattern = StringUtils.defaultIfBlank(pattern, "yyyy-mm-dd");
            } else if (fieldType == LocalTime.class) {
                pattern = StringUtils.defaultIfBlank(pattern, "HH:mm:ss");
            }
        }
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat(pattern));
        this.mapCellStyle.put(typeName, cellStyle);
        return cellStyle;
    }

    private void createHeaderRow(Sheet sheet, List<ExcelColumnMetadata> sortedColumn) {
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < sortedColumn.size(); i++) {
            ExcelColumnMetadata col = sortedColumn.get(i);
            Cell cell = headerRow.createCell(i);
            CellStyle cellStyle = getOrCreateValueCellStyle(col.getColumnName(), col);
            Font defaultFont = getDefaultFont(12);
            cellStyle.setFont(defaultFont);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(col.getColumnName());
        }
    }

    private Object getValueFromField(@NotNull Field field, @NotNull Object obj) {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        Object objVal = null;
        try {
            objVal = field.get(obj);
        } catch (IllegalAccessException e) {
            log.error("Failed to get value from Field: {}", field.getName());
        } finally {
            field.setAccessible(isAccessible);
        }
        return objVal;
    }

    private <T> ExcelModelMetadata createModelMetadata(Class<T> clazz) throws InvalidClassException {
        ExcelModel excelModel = clazz.getAnnotation(ExcelModel.class);
        if (excelModel == null)
            throw new InvalidClassException(clazz.getName(),
                    "Failed to create Excel Model Metadata. missing ExcelModel annotation.");

        return ExcelModelMetadata.builder()
                .className(clazz.getName())
                .sheetName(excelModel.sheetName())
                .clazz(clazz)
                .columns(createExcelColumnMetadataList(clazz))
                .build();
    }

    private <T> LinkedList<ExcelColumnMetadata> createExcelColumnMetadataList(Class<T> clazz) {
        LinkedList<ExcelColumnMetadata> excelColumnMetadataList = new LinkedList<>();
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            Field[] declaredFields = c.getDeclaredFields();
            for (Field classField : declaredFields) {
                ExcelColumn annExcelColumn = classField.<ExcelColumn>getAnnotation(ExcelColumn.class);
                if (annExcelColumn != null) {
                    boolean isTypeExcelModel = classField.getType().isAnnotationPresent((Class) ExcelModel.class);
                    if (isTypeExcelModel) {
                        LinkedList<ExcelColumnMetadata> excelColumnMetadataListFrField = createExcelColumnMetadataList(
                                classField
                                        .getType());
                        excelColumnMetadataListFrField.forEach(col -> col.setParentField(classField));
                        excelColumnMetadataList.addAll(excelColumnMetadataListFrField);
                    } else {
                        String headerName = (String) StringUtils.defaultIfBlank(annExcelColumn.headerName(), classField
                                .getName());
                        ExcelColumnMetadata excelColumnMetadata = (new ExcelColumnMetadata()).toBuilder()
                                .name(classField.getName())
                                .columnName(headerName)
                                .columnIndex(annExcelColumn.columnIndex())
                                .format(classField.getAnnotation(Format.class))
                                .exclude(classField.getAnnotation(Exclude.class))
                                .keyAsColumn(classField.getAnnotation(KeyAsColumn.class))
                                .field(classField)
                                .build();
                        excelColumnMetadataList.add(excelColumnMetadata);
                    }
                }
            }
        }
        return excelColumnMetadataList;
    }

    private <T> String getSheetNameFromClass(Class<T> clazz) {
        ExcelModel annSheetTemplate = clazz.getAnnotation(ExcelModel.class);
        if (annSheetTemplate == null)
            return clazz.getSimpleName();

        String sheetName = annSheetTemplate.sheetName();
        if (StringUtils.isNotBlank(sheetName))
            return sheetName;

        return clazz.getSimpleName();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (this.workbook != null)
            this.workbook.write(outputStream);
    }

    public void close() throws Exception {
        if (this.workbook != null) {
            this.workbook.close();
            log.info("Workbook closed.");
        }
    }
}