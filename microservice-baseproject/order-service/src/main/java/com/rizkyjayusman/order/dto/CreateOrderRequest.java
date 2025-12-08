package com.rizkyjayusman.order.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CreateOrderRequest {
    private List<Item> items;

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class Item {
        private Long productId;
        private Integer quantity;
    }
}
