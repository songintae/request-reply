package com.example.requestreply.order.domain;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);

    Optional<Order> findById(String orderId);
}
