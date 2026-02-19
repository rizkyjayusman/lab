package tech.noar.commons.models;

import io.quarkus.panache.common.Sort;
import tech.noar.commons.enums.SortDirection;

public class Pageable {
    public int page;
    public int pageSize;
    public Sort sort;

    public Pageable(int page, int pageSize, String sortBy, SortDirection direction) {
        this.page = page;
        this.pageSize = pageSize;
        this.sort = Sort.by(sortBy).direction(direction.getDirection());
    }

}
