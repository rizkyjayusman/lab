package com.rizkyjayusman.order.repository;

import com.rizkyjayusman.order.client.UserClient;
import com.rizkyjayusman.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserId(UserClient userClient);
}
