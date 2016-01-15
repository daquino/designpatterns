package com.example.designpatterns.observer.mock;

import com.example.designpatterns.observer.Observer;
import com.example.designpatterns.observer.Subject;
import com.example.designpatterns.observer.TimeSource;

import java.util.ArrayList;
import java.util.List;

public class MockTimeSource extends Subject implements TimeSource {
    private int hours;
    private int minutes;
    private int seconds;
    private List<Observer> observers;

    public MockTimeSource() {
        observers = new ArrayList<>();
    }

    public void setTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        notifyObservers();
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getSeconds() {
        return seconds;
    }
}
