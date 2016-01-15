package com.example.designpatterns.proxy;

import com.example.designpatterns.proxy.db.DB;

import java.sql.SQLException;

public class OrderProxy implements Order {
    private int orderId;

    public OrderProxy(final int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String getCustomerId() {
        try {
            OrderData od = DB.getOrderData(orderId);
            return od.getCustomerId();
        }
        catch (SQLException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public void addItem(final Product product, final int quantity) {
        try {
            ItemData id = new ItemData(orderId, product.getSku(), quantity);
            DB.store(id);
        }
        catch (Exception exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    public double total() {
        try {
            OrderImp orderImp = new OrderImp(getCustomerId());
            ItemData[] items = DB.getItemsForOrder(orderId);
            for(ItemData item: items) {
                orderImp.addItem(new ProductProxy(item.getSku()), item.getQuantity());
            }
            return orderImp.total();
        }
        catch(Exception exc) {
            throw new RuntimeException(exc);
        }
    }
}
