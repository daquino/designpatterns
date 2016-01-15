package com.example.designpatterns.adapter.switches.impl;

import com.example.designpatterns.adapter.switches.Switchable;
import com.example.designpatterns.adapter.switches.iphone.Iphone;

public class IphoneAdapter implements Switchable{
    private Iphone iphone;

    public IphoneAdapter(final Iphone iphone) {
        this.iphone = iphone;
    }

    @Override
    public void turnOn() {
        iphone.wakeUp();
    }

    @Override
    public void turnOff() {
        iphone.sleep();
    }
}
