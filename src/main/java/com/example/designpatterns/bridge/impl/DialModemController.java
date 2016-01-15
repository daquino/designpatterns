package com.example.designpatterns.bridge.impl;

import com.example.designpatterns.bridge.Modem;
import com.example.designpatterns.bridge.ModemConnectionController;

public class DialModemController extends ModemConnectionController {
    public DialModemController(final Modem modem) {
        super(modem);
    }

    @Override
    protected void dialImp(final char[] c) {
        modem.dial(c);
    }

    @Override
    protected void hangupImp() {
        modem.hangup();
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
