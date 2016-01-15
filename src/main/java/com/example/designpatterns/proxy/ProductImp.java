package com.example.designpatterns.proxy;

public class ProductImp implements Product {
    private String name;
    private double price;
    private String sku;

    public ProductImp(final String name, final double price, final String sku) {
        this.name = name;
        this.price = price;
        this.sku = sku;
    }

    public ProductImp(final String name, final double price) {
        this(name, price, "");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getSku() {
        return sku;
    }
}
