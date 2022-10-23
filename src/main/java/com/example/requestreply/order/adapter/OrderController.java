package com.example.requestreply.order.adapter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping
    public void orderReceipt(OrderReceiptRequest request) {

    }
}
