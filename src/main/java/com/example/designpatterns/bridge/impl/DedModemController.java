package com.example.designpatterns.bridge.impl;

import com.example.designpatterns.bridge.Modem;
import com.example.designpatterns.bridge.ModemConnectionController;

public class DedModemController extends ModemConnectionController {
    private boolean connected;
    public DedModemController(final Modem modem) {
        super(modem);
    }

    @Override
    protected void dialImp(final char[] c) {
        System.out.println("Faking dialing");
        connected = true;
    }

    @Override
    protected void hangupImp() {
        System.out.println("Faking hanging up");
        connected = false;
    }

    @Override
    protected void sendImp(final char c) {
        modem.send(c);
    }

    @Override
    protected void receiveImp() {
        modem.receive();
    }
}
