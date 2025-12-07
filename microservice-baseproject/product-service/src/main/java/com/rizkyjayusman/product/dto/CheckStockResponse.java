package com.rizkyjayusman.product.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CheckStockResponse {
    private boolean success;
    private List<FailedItem> failed;

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class FailedItem {
        private Long productId;
        private Integer required;
        private Integer available;
    }
}
