package tech.noar.commons.enums;

public enum ExcelVersion {
    XLS(".xls", "application/vnd.ms-excel", 65536, 256),
    XLSX(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", 1048576, 16384),
    XLSX_STREAM(".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", 1048576, 16384);

    private final String extension;
    private final String mime;
    private final int maxRow;
    private final int maxColumn;

    ExcelVersion(String extension, String mime, int maxRow, int maxColumn) {
        this.extension = extension;
        this.mime = mime;
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    public String getExtension() {
        return extension;
    }

    public String getMime() {
        return mime;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public int getMaxColumn() {
        return maxColumn;
    }

}
