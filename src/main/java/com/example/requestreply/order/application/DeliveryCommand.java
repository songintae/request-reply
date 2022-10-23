package com.example.requestreply.order.application;

import com.example.requestreply.common.Command;
import com.example.requestreply.order.domain.Menu;
import com.example.requestreply.order.domain.Orderer;
import com.example.requestreply.order.domain.Shop;
import lombok.Getter;

import java.util.List;

import static com.example.requestreply.order.application.DeliveryCommand.DeliveryCreateData;


@Getter
public class DeliveryCommand extends Command<DeliveryCreateData> {

    private DeliveryCommand() {

    }

    public DeliveryCommand(String transactionId, DeliveryCreateData data) {
        super(transactionId, "DELIVERY_CREATE", data);
    }

    @Getter
    public static class DeliveryCreateData {
        private String orderId;
        private Orderer orderer;
        private Shop shop;
        private List<Menu> menus;
        private long amountOfPayment;

        private DeliveryCreateData() {
            //for-serialize
        }

        public DeliveryCreateData(String orderId, Orderer orderer, Shop shop, List<Menu> menus, long amountOfPayment) {
            this.orderId = orderId;
            this.orderer = orderer;
            this.shop = shop;
            this.menus = menus;
            this.amountOfPayment = amountOfPayment;
        }
    }

}
