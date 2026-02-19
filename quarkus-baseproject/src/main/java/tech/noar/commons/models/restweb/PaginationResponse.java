package tech.noar.commons.models.restweb;

import tech.noar.commons.helper.GenericBuilder;
import tech.noar.commons.models.PaginationResult;

import java.io.Serializable;

public final class PaginationResponse implements Serializable {

    private Integer size;
    private Integer page;
    private String[] sorts = new String[]{};

    private Long filteredRecords;

    private Boolean firstPage;
    private Boolean lastPage;

    private Integer totalPage;

    public static PaginationResponse build(PaginationResult<?> paginatedData) {
        PaginationResponse resp = new PaginationResponse();
        resp.filteredRecords = paginatedData.totalElements;
        resp.totalPage = paginatedData.totalPage;
        resp.page = paginatedData.page;
        resp.size = paginatedData.pageSize;
        resp.firstPage = (paginatedData.page <= 1);
        resp.lastPage = (paginatedData.page == paginatedData.totalPage);
        resp.sorts = paginatedData.sorts.stream()
                .map(column -> String.format("%s,%s", column.getName(), column.getDirection().name()))
                .toArray(String[]::new);

        return resp;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getPage() {
        return page;
    }

    public String[] getSorts() {
        return sorts;
    }

    public Long getFilteredRecords() {
        return filteredRecords;
    }

    public Boolean getFirstPage() {
        return firstPage;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }
}
