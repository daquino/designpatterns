package com.example.designpatterns.proxy;

public class Item {
    private int quantity;
    private Product product;

    public Item(final Product product, final int quantity) {
        this.quantity = quantity;
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
