package com.example.requestreply.order.application;

import com.example.requestreply.common.CommandReply;
import lombok.Getter;

@Getter
public class DeliveryCreateReply extends CommandReply<DeliveryCreateReply.DeliveryCreateReplyData> {

    @Getter
    public static class DeliveryCreateReplyData {
        private String deliveryId;
    }
}
