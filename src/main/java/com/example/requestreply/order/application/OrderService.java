package com.example.requestreply.order.application;

import com.example.requestreply.order.application.DeliveryCommand.DeliveryCreateData;
import com.example.requestreply.order.domain.Menu;
import com.example.requestreply.order.domain.Order;
import com.example.requestreply.order.domain.OrderRepository;
import com.example.requestreply.order.domain.Orderer;
import com.example.requestreply.order.domain.Shop;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class OrderService {
    private final OrderRepository orderRepository;
    private final DeliveryCommander deliveryCommander;

    public OrderService(OrderRepository orderRepository, DeliveryCommander deliveryCommander) {
        this.orderRepository = orderRepository;
        this.deliveryCommander = deliveryCommander;
    }

    public CompletableFuture<DeliveryCreateReply> receiptOrder(Orderer orderer,
                                                                     Shop shop,
                                                                     List<Menu> menus,
                                                                     long amountOfPayment) {

        final Order order = new Order(orderer, shop, menus, amountOfPayment);
        orderRepository.save(order);

        final String transactionId = UUID.randomUUID().toString();
        final DeliveryCreateData deliveryCreateData = new DeliveryCreateData(order.getOrderId(), orderer, shop, menus, amountOfPayment);

        return deliveryCommander.create(new DeliveryCommand(transactionId, deliveryCreateData));
    }
}
