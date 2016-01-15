package com.example.designpatterns.proxy;

import java.util.Vector;

public class OrderImp implements Order {
    private Vector<Item> items;
    private String customerId;

    public OrderImp(String customerId) {
        this.customerId = customerId;
        items = new Vector<>();
    }

    @Override
    public String getCustomerId() {
        return null;
    }

    @Override
    public void addItem(final Product product, final int quantity) {
        Item item = new Item(product, quantity);
        items.add(item);
    }

    @Override
    public double total() {
        return items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getProduct().getPrice())
                .sum();
    }
}
