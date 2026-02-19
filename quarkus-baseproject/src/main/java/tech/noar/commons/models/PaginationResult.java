package tech.noar.commons.models;

import io.quarkus.panache.common.Sort.Column;

import java.util.List;
import java.util.function.Function;

public class PaginationResult<T> {

    public List<T> content;
    public int page;
    public int pageSize;
    public int totalPage;
    public long totalElements;
    public List<Column> sorts;

    public <O> PaginationResult<O> transformContent(Function<? super T, O> mapper) {
        PaginationResult<O> newPagination = new PaginationResult<>();
        newPagination.content = this.content.stream().map(mapper).toList();
        newPagination.page = this.page;
        newPagination.pageSize = this.pageSize;
        newPagination.totalPage = this.totalPage;
        newPagination.totalElements = this.totalElements;
        newPagination.sorts = this.sorts;
        return newPagination;
    }

}
