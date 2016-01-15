package com.example.designpatterns.proxy;

import com.example.designpatterns.proxy.db.DB;
import com.example.designpatterns.proxy.db.ProductData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DBTest {

    @Before
    public void setUp() throws Exception {
        DB.init();
    }

    @After
    public void tearDown() throws Exception {
        DB.close();
    }

    @Test
    public void testStoreProduct() throws Exception {
        ProductData storedProduct = new ProductData("999", "My Product", 1234);
        DB.store(storedProduct);
        ProductData retrievedProduct = DB.getProductData("999");
        DB.deleteProductData("999");
        assertThat(retrievedProduct, is(storedProduct));
    }

    @Test
    public void testOrderKeyGeneration() throws Exception {
        OrderData o1 = DB.newOrder("Bob");
        OrderData o2 = DB.newOrder("Bill");
        int firstOrderId = o1.getOrderId();
        int secondOrderId = o2.getOrderId();
        assertThat(firstOrderId, is(secondOrderId-1));

    }
}
