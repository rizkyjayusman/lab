package com.rizkyjayusman.order.service;

import com.rizkyjayusman.order.client.ProductClient;
import com.rizkyjayusman.order.client.UserClient;
import com.rizkyjayusman.order.dto.CreateOrderRequest;
import com.rizkyjayusman.order.dto.CreateOrderResponse;
import com.rizkyjayusman.order.entity.Order;
import com.rizkyjayusman.order.entity.OrderItem;
import com.rizkyjayusman.order.enumeration.OrderStatus;
import com.rizkyjayusman.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest request) {

        if (!userClient.isUserValid(request.getUserId())) {
            throw new RuntimeException("User not valid");
        }

        if (!productClient.checkStock(request.getItems())) {
            // TODO : we need to handle which product that contains stock not enough
            throw new RuntimeException("Stock not enough for product x");
        }

        Order order = Order.builder()
                .userId(request.getUserId())
                .status(OrderStatus.CREATED)
                .createdAt(Instant.now())
                .build();

        var items = request.getItems().stream()
                .map(i -> OrderItem.builder()
                        .productId(i.getProductId())
                        .quantity(i.getQuantity())
                        .priceAtOrder(0)
                        .order(order)
                        .build())
                .collect(Collectors.toList());

        order.setItems(items);

        Order saved = orderRepository.save(order);

        if (! productClient.decreaseStock(request.getItems())) {
            // TODO : we need to handle which product that contains stock not enough
            throw new RuntimeException("Stock not enough for product x");
        }

        return CreateOrderResponse.builder()
                .orderId(saved.getId())
                .status(saved.getStatus())
                .build();
    }
}
