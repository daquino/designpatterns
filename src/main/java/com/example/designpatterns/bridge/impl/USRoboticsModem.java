package com.example.designpatterns.bridge.impl;

import com.example.designpatterns.bridge.Modem;

public class USRoboticsModem implements Modem {
    @Override
    public void dial(final char[] phoneNumber) {
        System.out.println(String.format("Dialing %s with a US Robotics Modem", String.valueOf(phoneNumber)));
    }

    @Override
    public void hangup() {
        System.out.println("Hanging up US Robotics Modem.");
    }

    @Override
    public void send(final char c) {
        System.out.println(String.format("Sending '%s' to US Robotics Modem", c));
    }

    @Override
    public void receive() {
        System.out.println("Receiving data from US Robotics Modem.");
    }
}
