package tech.noar.commons.generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tech.noar.commons.annotations.excel.*;

public class ExcelColumnMetadata {
    private String name;

    private String columnName;

    private int columnIndex;

    private Field field;

    private Field parentField;

    private String defaultValue;

    private Format format;

    private Exclude exclude;

    private KeyAsColumn keyAsColumn;

    private boolean mustExclude;

    private List<ExcelColumnMetadata> childs;

    public void setName(String name) {
        this.name = name;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public void setParentField(Field parentField) {
        this.parentField = parentField;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public void setExclude(Exclude exclude) {
        this.exclude = exclude;
    }

    public void setKeyAsColumn(KeyAsColumn keyAsColumn) {
        this.keyAsColumn = keyAsColumn;
    }

    public void setMustExclude(boolean mustExclude) {
        this.mustExclude = mustExclude;
    }

    public void setChilds(List<ExcelColumnMetadata> childs) {
        this.childs = childs;
    }

    public static ExcelColumnMetadataBuilder builder() {
        return new ExcelColumnMetadataBuilder();
    }

    public ExcelColumnMetadataBuilder toBuilder() {
        return (new ExcelColumnMetadataBuilder()).name(this.name).columnName(this.columnName).columnIndex(this.columnIndex).field(this.field).parentField(this.parentField).defaultValue(this.defaultValue).format(this.format).exclude(this.exclude).keyAsColumn(this.keyAsColumn).mustExclude(this.mustExclude).childs(this.childs);
    }

    public static class ExcelColumnMetadataBuilder {
        private String name;

        private String columnName;

        private int columnIndex;

        private Field field;

        private Field parentField;

        private String defaultValue;

        private Format format;

        private Exclude exclude;

        private KeyAsColumn keyAsColumn;

        private boolean mustExclude;

        private List<ExcelColumnMetadata> childs;

        public ExcelColumnMetadataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ExcelColumnMetadataBuilder columnName(String columnName) {
            this.columnName = columnName;
            return this;
        }

        public ExcelColumnMetadataBuilder columnIndex(int columnIndex) {
            this.columnIndex = columnIndex;
            return this;
        }

        public ExcelColumnMetadataBuilder field(Field field) {
            this.field = field;
            return this;
        }

        public ExcelColumnMetadataBuilder parentField(Field parentField) {
            this.parentField = parentField;
            return this;
        }

        public ExcelColumnMetadataBuilder defaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public ExcelColumnMetadataBuilder format(Format format) {
            this.format = format;
            return this;
        }

        public ExcelColumnMetadataBuilder exclude(Exclude exclude) {
            this.exclude = exclude;
            return this;
        }

        public ExcelColumnMetadataBuilder keyAsColumn(KeyAsColumn keyAsColumn) {
            this.keyAsColumn = keyAsColumn;
            return this;
        }

        public ExcelColumnMetadataBuilder mustExclude(boolean mustExclude) {
            this.mustExclude = mustExclude;
            return this;
        }

        public ExcelColumnMetadataBuilder childs(List<ExcelColumnMetadata> childs) {
            this.childs = childs;
            return this;
        }

        public ExcelColumnMetadata build() {
            return new ExcelColumnMetadata(this.name, this.columnName, this.columnIndex, this.field, this.parentField, this.defaultValue, this.format, this.exclude, this.keyAsColumn, this.mustExclude, this.childs);
        }

        public String toString() {
            return "ExcelColumnMetadata.ExcelColumnMetadataBuilder(name=" + this.name + ", columnName=" + this.columnName + ", columnIndex=" + this.columnIndex + ", field=" + this.field + ", parentField=" + this.parentField + ", defaultValue=" + this.defaultValue + ", format=" + this.format + ", exclude=" + this.exclude + ", keyAsColumn=" + this.keyAsColumn + ", mustExclude=" + this.mustExclude + ", childs=" + this.childs + ")";
        }
    }

    public ExcelColumnMetadata() {
        this.childs = new ArrayList<>();
    }

    public ExcelColumnMetadata(String name, String columnName, int columnIndex, Field field, Field parentField, String defaultValue, Format format, Exclude exclude, KeyAsColumn keyAsColumn, boolean mustExclude, List<ExcelColumnMetadata> childs) {
        this.childs = new ArrayList<>();
        this.name = name;
        this.columnName = columnName;
        this.columnIndex = columnIndex;
        this.field = field;
        this.parentField = parentField;
        this.defaultValue = defaultValue;
        this.format = format;
        this.exclude = exclude;
        this.keyAsColumn = keyAsColumn;
        this.mustExclude = mustExclude;
        this.childs = childs;
    }

    public String getName() {
        return this.name;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public int getColumnIndex() {
        return this.columnIndex;
    }

    public Field getField() {
        return this.field;
    }

    public Field getParentField() {
        return this.parentField;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public Format getFormat() {
        return this.format;
    }

    public Exclude getExclude() {
        return this.exclude;
    }

    public KeyAsColumn getKeyAsColumn() {
        return this.keyAsColumn;
    }

    public boolean isMustExclude() {
        return this.mustExclude;
    }

    public List<ExcelColumnMetadata> getChilds() {
        return this.childs;
    }

    public static ExcelColumnMetadata createInstance(Field field) {
        if (field == null)
            return null;
        ExcelColumn annColumn = field.<ExcelColumn>getAnnotation(ExcelColumn.class);
        if (annColumn == null)
            return null;
        ExcelColumnMetadata columnMetadata = (new ExcelColumnMetadata()).toBuilder()
                .name(field.getName())
                .columnName(field.getName())
                .field(field).build();

        if (StringUtils.isNotBlank(annColumn.headerName()))
            columnMetadata.setColumnName(annColumn.headerName());
        if (StringUtils.isNotBlank(annColumn.defaultValue()))
            columnMetadata.setDefaultValue(annColumn.defaultValue());
        if (annColumn.columnIndex() > 0)
            columnMetadata.setColumnIndex(annColumn.columnIndex());
        columnMetadata.setFormat(field.<Format>getAnnotation(Format.class));
        columnMetadata.setExclude(field.<Exclude>getAnnotation(Exclude.class));
        columnMetadata.setKeyAsColumn(field.<KeyAsColumn>getAnnotation(KeyAsColumn.class));
        boolean isTypeExcelModel = field.getType().isAnnotationPresent((Class) ExcelModel.class);
        if (isTypeExcelModel) {
            List<ExcelColumnMetadata> childsFromFieldModel = createChildsFromFieldModel(field
                    .getType());
            childsFromFieldModel.forEach(col -> col.setParentField(field));
            columnMetadata.setChilds(childsFromFieldModel);
        }
        return columnMetadata;
    }

    private static List<ExcelColumnMetadata> createChildsFromFieldModel(Class<?> clazz) {
        List<ExcelColumnMetadata> excelColumnMetadatas = new ArrayList<>();
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            Field[] declaredFields = c.getDeclaredFields();
            for (Field classField : declaredFields) {
                ExcelColumn annExcelColumn = classField.<ExcelColumn>getAnnotation(ExcelColumn.class);
                if (annExcelColumn != null) {
                    boolean isTypeExcelModel = classField.getType().isAnnotationPresent((Class)ExcelModel.class);
                    if (isTypeExcelModel) {
                        List<ExcelColumnMetadata> excelColumnMetadataListFrField = createChildsFromFieldModel(classField
                                .getType());
                        excelColumnMetadataListFrField.forEach(col -> col.setParentField(classField));
                        excelColumnMetadatas.addAll(excelColumnMetadataListFrField);
                    } else {
                        excelColumnMetadatas.add(createInstance(classField));
                    }
                }
            }
        }
        return excelColumnMetadatas;
    }
}