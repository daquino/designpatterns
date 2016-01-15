package com.example.designpatterns.observer.mock;

import com.example.designpatterns.observer.Observer;
import com.example.designpatterns.observer.TimeSource;

public class MockTimeSink implements Observer {
    private int hours;
    private int minutes;
    private int seconds;
    private TimeSource timeSource;

    public MockTimeSink(final TimeSource timeSource) {
        this.timeSource = timeSource;
    }

    @Override
    public void update() {
        this.hours = timeSource.getHours();
        this.minutes = timeSource.getMinutes();
        this.seconds = timeSource.getSeconds();
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
