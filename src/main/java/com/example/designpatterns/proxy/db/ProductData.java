package com.example.designpatterns.proxy.db;

import com.google.common.base.Objects;

public class ProductData {
    private String sku;
    private String name;
    private double price;

    public ProductData(final String sku, final String name, final double price) {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(final String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return price == that.price &&
                Objects.equal(name, that.name) &&
                Objects.equal(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(price, name, sku);
    }
}
