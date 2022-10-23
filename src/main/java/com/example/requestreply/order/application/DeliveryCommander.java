package com.example.requestreply.order.application;

import java.util.concurrent.CompletableFuture;

public interface DeliveryCommander {
    CompletableFuture<DeliveryCreateReply> create(DeliveryCommand deliveryCommand);
}
