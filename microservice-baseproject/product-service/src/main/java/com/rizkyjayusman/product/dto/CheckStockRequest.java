package com.rizkyjayusman.product.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CheckStockRequest {

    private List<Item> items;

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Item {
        private Long productId;
        private Integer quantity;
    }
}
