package com.example.designpatterns.adapter;

import com.example.designpatterns.adapter.switches.impl.CoupledIphoneAdapter;
import com.example.designpatterns.adapter.switches.impl.IphoneAdapter;
import com.example.designpatterns.adapter.switches.iphone.Iphone;
import com.example.designpatterns.adapter.modem.Modem;
import com.example.designpatterns.adapter.modem.dedusers.DedicatedModem;
import com.example.designpatterns.adapter.modem.dedusers.DedicatedModemAdapter;
import com.example.designpatterns.adapter.modem.impl.ErniesModem;
import com.example.designpatterns.adapter.modem.impl.HayesModem;
import com.example.designpatterns.adapter.modem.impl.USRoboticsModem;
import com.example.designpatterns.adapter.switches.Switch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AdapterTest {

    @Test
    public void testAdapter() throws Exception {
        Iphone iphone = new Iphone();
        IphoneAdapter iphoneAdapter = new IphoneAdapter(iphone);
        Switch iphoneSwitch = new Switch(iphoneAdapter);

        iphoneSwitch.turnOff();
        assertThat(iphone.isSleeping(), is(true));
        iphoneSwitch.turnOn();
        assertThat(iphone.isSleeping(), is(false));
    }

    @Test
    public void testCoupledAdapter() throws Exception {
        CoupledIphoneAdapter adapter = new CoupledIphoneAdapter();
        Switch iphoneSwitch = new Switch(adapter);

        iphoneSwitch.turnOff();
        assertThat(adapter.isSleeping(), is(true));
        iphoneSwitch.turnOn();
        assertThat(adapter.isSleeping(), is(false));
    }

    @Test
    public void testModem() throws Exception {
        DedicatedModem dedicatedModem = new DedicatedModem();
        List<Modem> modems = new ArrayList<>();
        modems.add(new HayesModem());
        modems.add(new USRoboticsModem());
        modems.add(new ErniesModem());
        modems.add(new DedicatedModemAdapter(dedicatedModem));

        for(Modem modem: modems) {
            modem.dial(new char[] {'9', '1', '1'});
            modem.send('d');
            modem.receive();
            modem.hangup();
        }

    }
}
