package com.example.designpatterns.adapter.modem.dedusers;

import com.example.designpatterns.adapter.modem.Modem;

public class DedicatedModemAdapter implements Modem {
    private DedicatedModem modem;
    private boolean connected = false;

    public DedicatedModemAdapter(final DedicatedModem modem) {
        this.modem = modem;
    }


    @Override
    public void dial(final char[] phoneNumber) {
        connected = true;
        System.out.println(String.format("Fake dialing %s for dedicated modem", String.valueOf(phoneNumber)));
    }

    @Override
    public void hangup() {
        System.out.println("Fake hanging up dedicated modem");
        connected = false;
    }

    @Override
    public void send(final char c) {
        modem.send(c);
    }

    @Override
    public void receive() {
        modem.receive();
    }
}
