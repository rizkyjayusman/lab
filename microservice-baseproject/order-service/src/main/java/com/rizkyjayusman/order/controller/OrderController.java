package com.rizkyjayusman.order.controller;

import com.rizkyjayusman.order.dto.CreateOrderRequest;
import com.rizkyjayusman.order.dto.CreateOrderResponse;
import com.rizkyjayusman.order.dto.OrderResponse;
import com.rizkyjayusman.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAll(@RequestHeader("X-User-Id") Long userId) {
        return orderService.getAllOrders(userId);
    }

    @GetMapping("/{id}")
    public OrderResponse getById(@PathVariable Long id, @RequestHeader("X-User-Id") Long userId) {
        return orderService.getOrderById(id, userId);
    }

    @PostMapping
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest request, @RequestHeader("X-User-Id") Long userId) {
        return orderService.createOrder(request, userId);
    }
}
