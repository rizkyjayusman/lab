package com.rizkyjayusman.order.repository;

import com.rizkyjayusman.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
