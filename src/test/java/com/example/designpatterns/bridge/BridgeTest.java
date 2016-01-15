package com.example.designpatterns.bridge;

import com.example.designpatterns.bridge.impl.DedModemController;
import com.example.designpatterns.bridge.impl.DialModemController;
import com.example.designpatterns.bridge.impl.HayesModem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BridgeTest {

    @Test
    public void testDialClients() throws Exception {
        List<ModemClient> modemClients = new ArrayList<>();
        modemClients.add(new DialModemController(new HayesModem()));
        modemClients.add(new DedModemController(new HayesModem()));

        for(ModemClient client: modemClients) {
            client.dial(new char[] {'9','1','1'});
            client.send('d');
            client.receive();
            client.hangup();
        }
    }

    @Test
    public void testDedClients() throws Exception {
        List<DedModemClient> modemClients = new ArrayList<>();
        modemClients.add(new DialModemController(new HayesModem()));
        modemClients.add(new DedModemController(new HayesModem()));

        for(DedModemClient client: modemClients) {
            client.send('d');
            client.receive();
        }

    }
}
