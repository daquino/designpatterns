package com.example.designpatterns.proxy;

public interface Order {
    String getCustomerId();
    void addItem(Product product, int quantity);
    double total();
}
