package com.example.designpatterns.abstractserver.impl;

import com.example.designpatterns.abstractserver.Switchable;

public class Fan implements Switchable {
    private boolean spinning;
    @Override
    public void turnOn() {
        spinning = true;
    }

    @Override
    public void turnOff() {
        spinning = false;
    }

    public boolean isSpinning() {
        return spinning;
    }
}
