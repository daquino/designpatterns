package com.example.designpatterns.bridge;

public abstract class ModemConnectionController implements ModemClient, DedModemClient {

    protected Modem modem;


    public ModemConnectionController(final Modem modem) {
        this.modem = modem;
    }

    @Override
    public void dial(final char[] phoneNumber) {
        dialImp(phoneNumber);
    }

    @Override
    public void hangup() {
        hangupImp();
    }

    @Override
    public void send(final char c) {
        modem.send(c);
    }

    @Override
    public void receive() {
        modem.receive();
    }

    protected abstract void dialImp(final char[] c);
    protected abstract void hangupImp();
    protected abstract void sendImp(char c);
    protected abstract void receiveImp();
}
