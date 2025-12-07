package com.rizkyjayusman.order.dto;

import com.rizkyjayusman.order.enumeration.OrderStatus;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class CreateOrderResponse {
    private Long orderId;
    private OrderStatus status;
}
