package com.example.designpatterns.activeobject;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;

public class TestSleepCommand {
    private boolean commandExecuted = false;
    @Test
    public void testSleep() throws Exception {
        Runnable wakeup = () -> commandExecuted = true;
        ActiveObjectEngine engine = new ActiveObjectEngine();
        SleepCommand command = new SleepCommand(1000, engine, wakeup);
        engine.addCommand(command);
        long start = System.currentTimeMillis();
        engine.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;
        System.out.println(sleepTime);
        assertThat(sleepTime, is(greaterThanOrEqualTo(1000L)));
        assertThat(sleepTime, is(lessThan(1100L)));
        assertThat(commandExecuted, is(true));
    }
}
