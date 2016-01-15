package com.example.designpatterns.bridge;

public class Switch {
    private final Switchable switchable;

    public Switch(final Switchable switchable) {
        this.switchable = switchable;
    }

    public void turnOn() {
        switchable.turnOn();
    }

    public void turnOff() {
        switchable.turnOff();
    }
}
