package com.rizkyjayusman.order.service;

import com.rizkyjayusman.order.client.ProductClient;
import com.rizkyjayusman.order.client.UserClient;
import com.rizkyjayusman.order.dto.CreateOrderRequest;
import com.rizkyjayusman.order.dto.CreateOrderResponse;
import com.rizkyjayusman.order.dto.OrderItemResponse;
import com.rizkyjayusman.order.dto.OrderResponse;
import com.rizkyjayusman.order.entity.Order;
import com.rizkyjayusman.order.entity.OrderItem;
import com.rizkyjayusman.order.enumeration.OrderStatus;
import com.rizkyjayusman.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final ProductClient productClient;

    public List<OrderResponse> getAllOrders(Long userId) {
        return orderRepository.findAllByUserId(userClient)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public OrderResponse getOrderById(Long id, Long userId) {
        var order = orderRepository.findById(id)
                .stream()
                .filter(e -> e.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("order not found : " + id));

        return toResponse(order);
    }

    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest request, Long userId) {

        if (!userClient.isUserValid(userId)) {
            throw new RuntimeException("User not valid");
        }

        if (!productClient.checkStock(request.getItems())) {
            // TODO : we need to handle which product that contains stock not enough
            throw new RuntimeException("Stock not enough for product x");
        }

        Order order = Order.builder()
                .userId(userId)
                .status(OrderStatus.CREATED)
                .createdAt(LocalDateTime.now())
                .build();

        var items = request.getItems().stream()
                .map(i -> OrderItem.builder()
                        .productId(i.getProductId())
                        .quantity(i.getQuantity())
                        .price(BigDecimal.ZERO)
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

    private OrderResponse toResponse(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .totalAmount(order.getTotalAmount())
                .status(order.getStatus().name())
                .createdAt(order.getCreatedAt())
                .items(order.getItems().stream()
                        .map(i -> OrderItemResponse.builder()
                                .productId(i.getProductId())
                                .quantity(i.getQuantity())
                                .price(i.getPrice())
                                .build()
                        ).toList())
                .build();
    }
}
