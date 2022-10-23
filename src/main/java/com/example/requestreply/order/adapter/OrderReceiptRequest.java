package com.example.requestreply.order.adapter;

import com.example.requestreply.order.domain.Menu;
import com.example.requestreply.order.domain.Orderer;
import com.example.requestreply.order.domain.Shop;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderReceiptRequest {
    private Orderer orderer;
    private Shop shop;
    private List<Menu> menus;
    private long amountOfPayment;
}
