package com.example.designpatterns.abstractserver.impl;

import com.example.designpatterns.abstractserver.Switchable;

public class Lamp implements Switchable {
    private boolean lit;

    @Override
    public void turnOn() {
        this.lit = true;
    }

    @Override
    public void turnOff() {
        this.lit = false;
    }

    public boolean isLit() {
        return lit;
    }
}
