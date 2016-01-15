package com.example.designpatterns.proxy.db;

import com.example.designpatterns.proxy.ItemData;
import com.example.designpatterns.proxy.OrderData;

import java.sql.*;
import java.util.LinkedList;

public class DB {
    private static Connection connection;

    public static void init() throws Exception {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection("jdbc:h2:~/sample", "sa", "");
    }

    public static void store(ProductData pd) throws Exception {
        PreparedStatement ps = buildInsertionStatement(pd);
        executeStatement(ps);
    }

    private static PreparedStatement buildInsertionStatement(ProductData pd) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into products values (?,?,?)");
        statement.setString(1, pd.getSku());
        statement.setString(2, pd.getName());
        statement.setDouble(3, pd.getPrice());
        return statement;
    }

    public static void executeStatement(PreparedStatement ps) throws SQLException {
        ps.execute();
        ps.close();
    }

    public static ProductData getProductData(String sku) throws Exception {
        PreparedStatement s = buildProductQueryStatement(sku);
        ResultSet rs = executeQueryStatement(s);
        ProductData pd = extractProductDataFromResultSet(rs);
        rs.close();
        s.close();
        return pd;
    }

    private static PreparedStatement buildProductQueryStatement(final String sku) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from products where sku = ?");
        preparedStatement.setString(1, sku);
        return preparedStatement;
    }

    private static ResultSet executeQueryStatement(final PreparedStatement s) throws SQLException {
        ResultSet rs = s.executeQuery();
        rs.next();
        return rs;
    }

    private static ProductData extractProductDataFromResultSet(final ResultSet rs) throws SQLException {
        String sku = rs.getString(1);
        String name = rs.getString(2);
        double price = rs.getDouble(3);
        return new ProductData(sku, name, price);
    }

    public static void deleteProductData(String sku) throws Exception {
        executeStatement(buildProductDeleteStatement(sku));
    }

    private static PreparedStatement buildProductDeleteStatement(final String sku) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from products where sku = ?");
        preparedStatement.setString(1, sku);
        return preparedStatement;
    }

    public static void close() throws Exception {
        connection.close();
    }

    public static OrderData newOrder(final String customerId) throws Exception{
        int newMaxOrderId = getMaxOrderId() + 1;
        PreparedStatement s = connection.prepareStatement("insert into orders(orderId, cusid) values(?,?)");
        s.setInt(1, newMaxOrderId);
        s.setString(2, customerId);
        executeStatement(s);
        return new OrderData(customerId, newMaxOrderId);
    }

    private static int getMaxOrderId() throws SQLException {
        Statement qs = connection.createStatement();
        ResultSet rs = qs.executeQuery("select max(orderId) from orders;");
        rs.next();
        int maxOrderId = rs.getInt(1);
        rs.close();
        return maxOrderId;
    }

    public static void store(final ItemData id) throws SQLException {
        PreparedStatement statement = buildItemInsertionStatement(id);
        executeStatement(statement);
    }

    private static PreparedStatement buildItemInsertionStatement(final ItemData id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into items(orderId,sku,quantity) values (?,?,?)");
        preparedStatement.setInt(1, id.getOrderId());
        preparedStatement.setString(2, id.getSku());
        preparedStatement.setInt(3, id.getQuantity());
        return preparedStatement;
    }

    public static ItemData[] getItemsForOrder(final int orderId) throws SQLException {
        PreparedStatement preparedStatement = buildItemsForOrderQueryStatement(orderId);
        ResultSet rs = preparedStatement.executeQuery();
        ItemData[] items = extractItemDataFromResultSet(rs);
        return items;
    }

    private static PreparedStatement buildItemsForOrderQueryStatement(final int orderId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from items where orderId = ?");
        statement.setInt(1, orderId);
        return statement;
    }

    private static ItemData[] extractItemDataFromResultSet(final ResultSet rs) throws SQLException {
        LinkedList<ItemData> items = new LinkedList<>();
        while(rs.next()) {
            int orderId = rs.getInt("orderId");
            String sku = rs.getString("sku");
            int quantity = rs.getInt("quantity");
            ItemData id = new ItemData(orderId, sku, quantity);
            items.add(id);
        }
        return items.toArray(new ItemData[items.size()]);
    }

    public static OrderData getOrderData(final int orderId) throws SQLException {
        PreparedStatement s = connection.prepareStatement("select cusid from orders where orderId = ?");
        s.setInt(1, orderId);
        ResultSet rs = s.executeQuery();
        OrderData orderData = null;
        if(rs.next()) {
            orderData = new OrderData(rs.getString("cusid"), orderId);
        }
        rs.close();
        s.close();
        return orderData;
    }
}
