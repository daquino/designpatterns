package com.example.designpatterns.adapter.switches.impl;

import com.example.designpatterns.adapter.switches.Switchable;
import com.example.designpatterns.adapter.switches.iphone.Iphone;

public class CoupledIphoneAdapter extends Iphone implements Switchable {
    @Override
    public void turnOn() {
        wakeUp();
    }

    @Override
    public void turnOff() {
        sleep();
    }
}
