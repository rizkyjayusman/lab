package com.rizkyjayusman.order.controller;

import com.rizkyjayusman.order.dto.CreateOrderRequest;
import com.rizkyjayusman.order.dto.CreateOrderResponse;
import com.rizkyjayusman.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}
