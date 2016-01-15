package com.example.designpatterns.adapter.switches.iphone;

public class Iphone {
    private boolean sleeping;

    public void wakeUp() {
        sleeping = false;
    }

    public void sleep() {
        sleeping = true;
    }

    public boolean isSleeping() {
        return sleeping;
    }
}
