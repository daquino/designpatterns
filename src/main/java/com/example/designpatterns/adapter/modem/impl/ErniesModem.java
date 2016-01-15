package com.example.designpatterns.adapter.modem.impl;

import com.example.designpatterns.adapter.modem.Modem;

public class ErniesModem implements Modem {
    @Override
    public void dial(final char[] phoneNumber) {
        System.out.println(String.format("Dialing %s with a Ernie's Modem", String.valueOf(phoneNumber)));
    }

    @Override
    public void hangup() {
        System.out.println("Hanging up Ernie's Modem.");
    }

    @Override
    public void send(final char c) {
        System.out.println(String.format("Sending '%s' to Ernie's Modem", c));
    }

    @Override
    public void receive() {
        System.out.println("Receiving data from Ernie's Modem.");
    }
}
