package com.example.designpatterns.adapter.modem.dedusers;

public class DedicatedModem {
    public void send(char c) {
        System.out.println(String.format("Sending %s to dedicated modem", c));
    }
    public void receive() {
        System.out.println("Receiving data from dedicated modem");
    }
}
