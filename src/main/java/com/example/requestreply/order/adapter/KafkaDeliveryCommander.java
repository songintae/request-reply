package com.example.requestreply.order.adapter;

import com.example.requestreply.common.Command;
import com.example.requestreply.common.CommandReply;
import com.example.requestreply.order.application.DeliveryCommand;
import com.example.requestreply.order.application.DeliveryCommander;
import com.example.requestreply.order.application.DeliveryCreateReply;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;

import java.util.concurrent.CompletableFuture;

public class KafkaDeliveryCommander implements DeliveryCommander {
    private final String topic;
    private final ReplyingKafkaTemplate<String, Command<?>, CommandReply<?>> replyingKafkaTemplate;

    public KafkaDeliveryCommander(String topic, ReplyingKafkaTemplate<String, Command<?>, CommandReply<?>> replyingKafkaTemplate) {
        this.topic = topic;
        this.replyingKafkaTemplate = replyingKafkaTemplate;
    }

    @Override
    public CompletableFuture<DeliveryCreateReply> create(DeliveryCommand deliveryCommand) {
        final RequestReplyFuture<String, Command<?>, CommandReply<?>> replyFuture = replyingKafkaTemplate.sendAndReceive(new ProducerRecord<>(topic, deliveryCommand));
        return replyFuture.completable().thenApply(record -> (DeliveryCreateReply) record.value());
    }
}
