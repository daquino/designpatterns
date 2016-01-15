package com.example.designpatterns.bridge;

public interface Modem {
    void dial(char[] phoneNumber);
    void hangup();
    void send(char c);
    void receive();
}
