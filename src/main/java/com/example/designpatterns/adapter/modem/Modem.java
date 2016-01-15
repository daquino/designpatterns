package com.example.designpatterns.adapter.modem;

public interface Modem {
    void dial(char[] phoneNumber);
    void hangup();
    void send(char c);
    void receive();
}
