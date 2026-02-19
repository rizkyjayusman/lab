package tech.noar.commons.generator;


import java.util.List;

class ExcelModelMetadata {
    private String className;

    private String sheetName;

    private Class<?> clazz;

    private List<ExcelColumnMetadata> columns;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void setColumns(List<ExcelColumnMetadata> columns) {
        this.columns = columns;
    }

    public static ExcelModelMetadataBuilder builder() {
        return new ExcelModelMetadataBuilder();
    }

    public ExcelModelMetadataBuilder toBuilder() {
        return (new ExcelModelMetadataBuilder()).className(this.className).sheetName(this.sheetName).clazz(this.clazz)
                .columns(this.columns);
    }

    public static class ExcelModelMetadataBuilder {
        private String className;

        private String sheetName;

        private Class<?> clazz;

        private List<ExcelColumnMetadata> columns;

        public ExcelModelMetadataBuilder className(String className) {
            this.className = className;
            return this;
        }

        public ExcelModelMetadataBuilder sheetName(String sheetName) {
            this.sheetName = sheetName;
            return this;
        }

        public ExcelModelMetadataBuilder clazz(Class<?> clazz) {
            this.clazz = clazz;
            return this;
        }

        public ExcelModelMetadataBuilder columns(List<ExcelColumnMetadata> columns) {
            this.columns = columns;
            return this;
        }

        public ExcelModelMetadata build() {
            return new ExcelModelMetadata(this.className, this.sheetName, this.clazz, this.columns);
        }

        public String toString() {
            return "ExcelModelMetadata.ExcelModelMetadataBuilder(className=" + this.className + ", sheetName=" + this.sheetName + ", clazz=" + this.clazz + ", columns=" + this.columns + ")";
        }
    }

    public ExcelModelMetadata() {
    }

    public ExcelModelMetadata(String className, String sheetName, Class<?> clazz, List<ExcelColumnMetadata> columns) {
        this.className = className;
        this.sheetName = sheetName;
        this.clazz = clazz;
        this.columns = columns;
    }

    public String getClassName() {
        return this.className;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public List<ExcelColumnMetadata> getColumns() {
        return this.columns;
    }
}