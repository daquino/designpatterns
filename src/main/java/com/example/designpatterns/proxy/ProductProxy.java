package com.example.designpatterns.proxy;

import com.example.designpatterns.proxy.db.DB;
import com.example.designpatterns.proxy.db.ProductData;

public class ProductProxy implements Product {
    private String sku;
    public ProductProxy(final String sku) {
        this.sku = sku;
    }

    @Override
    public String getSku() {
        return sku;
    }

    @Override
    public String getName() {
        ProductData pd = null;
        try {
            pd = DB.getProductData(sku);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pd.getName();
    }

    @Override
    public double getPrice() {
        ProductData pd = null;
        try {
            pd = DB.getProductData(sku);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pd.getPrice();
    }
}
