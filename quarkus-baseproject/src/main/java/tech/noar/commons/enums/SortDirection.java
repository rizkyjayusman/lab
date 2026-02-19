package tech.noar.commons.enums;

import io.quarkus.panache.common.Sort;

public enum SortDirection {

    ASC("asc", Sort.Direction.Ascending),
    DESC("desc", Sort.Direction.Descending);

    private String name;
    private Sort.Direction direction;

    SortDirection(String name, Sort.Direction direction) {
        this.name = name;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public Sort.Direction getDirection() {
        return direction;
    }
}
