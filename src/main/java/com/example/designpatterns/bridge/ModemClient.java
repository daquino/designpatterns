package com.example.designpatterns.bridge;

public interface ModemClient {
    void dial(char[] phoneNumber);
    void hangup();
    void send(char c);
    void receive();
}
