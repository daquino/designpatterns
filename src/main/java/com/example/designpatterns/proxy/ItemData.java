package com.example.designpatterns.proxy;

public class ItemData {
    private int orderId;
    private String sku;
    private int quantity;

    public ItemData(final int orderId, final String sku, final int quantity) {
        this.orderId = orderId;
        this.sku = sku;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }
}
