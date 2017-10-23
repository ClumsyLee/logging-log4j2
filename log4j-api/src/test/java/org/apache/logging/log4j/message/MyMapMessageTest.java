package org.apache.logging.log4j.message;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class MyMapMessageTest {

    Message nominal;
    Message empty;

    @Before
    public void setUp() {
        Map map = new HashMap();
        map.put("some key", "some value");
        map.put("some other key", "some other value");

        nominal = new StringMapMessage(map);
        empty = new StringMapMessage();
    }

    @Test
    public void nominalCanGetFormattedMessage() {
        assertEquals("some key=\"some value\" some other key=\"some other value\"", nominal.getFormattedMessage());
    }

    @Test
    public void nominalCanGetEmptyFormat() {
        assertEquals("", nominal.getFormat());
    }

    @Test
    public void nominalCanGetParametersAsValueArray() {
        assertEquals(new String[]{"some value", "some other value"}, nominal.getParameters());
    }

    @Test
    public void nominalCanGetNullThrowable() {
        assertNull(nominal.getThrowable());
    }

    @Test
    public void emptyCanGetEmptyFormattedMessage() {
        assertEquals("", empty.getFormattedMessage());
    }

    @Test
    public void emptyCanGetEmptyFormat() {
        assertEquals("", empty.getFormat());
    }

    @Test
    public void emptyCanGetParametersAsValueArray() {
        assertEquals(new String[]{}, empty.getParameters());
    }

    @Test
    public void emptyCanGetNullThrowable() {
        assertNull(empty.getThrowable());
    }
}