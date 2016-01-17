package com.example.designpatterns.activeobject;

public class SleepCommand implements Runnable {
    private Runnable wakeup;
    private ActiveObjectEngine engine;
    private long sleepTime;
    private long startTime;
    private boolean started;

    public SleepCommand(final long sleepTime, final ActiveObjectEngine engine, final Runnable wakeup) {
        this.wakeup = wakeup;
        this.engine = engine;
        this.sleepTime = sleepTime;
        this.startTime = 0;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();
        if(!started) {
            started = true;
            startTime = currentTime;
            engine.addCommand(this);
        }
        else if ((currentTime - startTime) < sleepTime) {
            engine.addCommand(this);
        }
        else {
            engine.addCommand(wakeup);
        }
    }
}
