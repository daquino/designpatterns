package com.example.designpatterns.proxy;

public class Customer {
    private String name;
    private String address;
    private String billingInformation;

    public Customer(final String name, final String address, final String billingInformation) {
        this.name = name;
        this.address = address;
        this.billingInformation = billingInformation;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getBillingInformation() {
        return billingInformation;
    }
}
