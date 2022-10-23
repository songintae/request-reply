package com.example.requestreply.order.domain;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Order {
    private String orderId;
    private Orderer orderer;
    private Shop shop;
    private List<Menu> menus;
    private long amountOfPayment;

    public Order(Orderer orderer, Shop shop, List<Menu> menus, long amountOfPayment) {
        this.orderId = UUID.randomUUID().toString();
        this.orderer = Objects.requireNonNull(orderer);
        this.shop = Objects.requireNonNull(shop);
        this.menus = Objects.requireNonNull(menus);
        this.amountOfPayment = amountOfPayment;
    }

    public String getOrderId() {
        return orderId;
    }
}
