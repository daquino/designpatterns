package com.example.designpatterns.abstractserver;

import com.example.designpatterns.abstractserver.impl.Fan;
import com.example.designpatterns.abstractserver.impl.Lamp;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AbstractServerTest {

    @Test
    public void testAbstractServer() throws Exception {
        Lamp lamp = new Lamp();
        Fan fan = new Fan();

        Switch lampSwitch = new Switch(lamp);

        lampSwitch.turnOn();
        assertThat(lamp.isLit(), is(true));
        lampSwitch.turnOff();
        assertThat(lamp.isLit(), is(false));

        Switch fanSwitch = new Switch(fan);
        fanSwitch.turnOn();
        assertThat(fan.isSpinning(), is(true));
        fanSwitch.turnOff();
        assertThat(fan.isSpinning(), is(false));
    }
}
