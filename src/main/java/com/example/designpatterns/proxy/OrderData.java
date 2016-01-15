package com.example.designpatterns.proxy;

public class OrderData {
    private String customerId;
    private int orderId;

    public OrderData(final String customerId, final int orderId) {
        this.customerId = customerId;
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getOrderId() {
        return orderId;
    }
}
