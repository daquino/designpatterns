package com.example.designpatterns.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTransaction {
    private Connection connection;

    public AddTransaction(final Connection connection) {
        this.connection = connection;
    }

    public void addItem(int orderId, String sku, int quantity) {
        try (PreparedStatement statement = connection.prepareStatement("insert into items values(?,?,?)")) {
            statement.setInt(1, orderId);
            statement.setString(2, sku);
            statement.setInt(3, quantity);
            statement.executeUpdate();
        }
        catch (SQLException e) {

        }
    }
}
