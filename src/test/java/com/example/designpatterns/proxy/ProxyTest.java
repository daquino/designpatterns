package com.example.designpatterns.proxy;

import com.example.designpatterns.proxy.db.DB;
import com.example.designpatterns.proxy.db.ProductData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProxyTest {

    @Before
    public void setUp() throws Exception {
        DB.init();
        ProductData pd = new ProductData("ProxyTest1", "ProxyTestname1", 456);
        DB.store(pd);
    }

    @After
    public void tearDown() throws Exception {
        DB.deleteProductData("ProxyTest1");
        DB.close();
    }

    @Test
    public void testProductProxy() throws Exception {
        Product p = new ProductProxy("ProxyTest1");
        assertThat(p.getPrice(), is(456.0));
        assertThat(p.getName(), is("ProxyTestname1"));
        assertThat(p.getSku(), is("ProxyTest1"));
    }

    @Test
    public void testOrderProxyTotal() throws Exception {
        DB.store(new ProductData("wheaties", "Wheaties", 349));
        DB.store(new ProductData("crest", "Crest", 258));
        ProductProxy wheaties = new ProductProxy("wheaties");
        ProductProxy crest = new ProductProxy("crest");
        OrderData od = DB.newOrder("testOrderProxy");
        OrderProxy order = new OrderProxy(od.getOrderId());
        order.addItem(crest, 1);
        order.addItem(wheaties, 2);
        assertThat(order.total(), is(956.0));
    }
}
