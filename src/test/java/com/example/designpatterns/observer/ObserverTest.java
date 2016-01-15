package com.example.designpatterns.observer;

import com.example.designpatterns.observer.mock.MockTimeSink;
import com.example.designpatterns.observer.mock.MockTimeSource;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ObserverTest {
    private MockTimeSource source;
    private MockTimeSink sink;

    @Before
    public void setUp() throws Exception {
        source = new MockTimeSource();
        sink = new MockTimeSink(source);
        source.registerObserver(sink);
    }

    @Test
    public void testTimeChange() throws Exception {
        source.setTime(3, 4, 5);
        assertSinkEquals(sink, 3, 4, 5);

        source.setTime(7, 8, 9);
        assertSinkEquals(sink, 7, 8, 9);
    }

    private void assertSinkEquals(MockTimeSink sink, int hours, int minutes, int seconds) {
        assertThat(sink.getHours(), is(hours));
        assertThat(sink.getMinutes(), is(minutes));
        assertThat(sink.getSeconds(), is(seconds));
    }

    @Test
    public void testMultipleSinks() throws Exception {
        MockTimeSink sink2 = new MockTimeSink(source);
        source.registerObserver(sink2);

        source.setTime(3, 4, 5);
        assertSinkEquals(sink, 3, 4, 5);
        assertSinkEquals(sink2, 3, 4, 5);

    }
}
