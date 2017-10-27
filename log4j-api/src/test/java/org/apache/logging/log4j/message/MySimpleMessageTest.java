package org.apache.logging.log4j.message;

import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by joekr on 10/22/17.
 */
public class MySimpleMessageTest {

    @Test
    public void nominal_case() throws Exception {
        final StringBuilder charSequence = new StringBuilder("nominal");
        final SimpleMessage message = new SimpleMessage(charSequence);
        assertEquals("nominal", message.getFormattedMessage());

        charSequence.setLength(0);
        charSequence.append("different value");

        final StringBuilder result = new StringBuilder();
        message.formatTo(result);
        assertEquals("nominal", result.toString());
    }

    @Test
    public void empty_case() throws Exception {
        final StringBuilder charSequence = new StringBuilder("");
        final SimpleMessage message = new SimpleMessage(charSequence);
        assertEquals("", message.getFormattedMessage());

        charSequence.setLength(0);
        charSequence.append("different value");

        final StringBuilder result = new StringBuilder();
        message.formatTo(result);
        assertEquals("", result.toString());
    }

    @Test
    public void null_case() throws Exception {
        final String string = null;
        final SimpleMessage message = new SimpleMessage(string);
        assertEquals(String.valueOf((String)null), message.getFormattedMessage());
    }

    @Test
    public void get_format(){
        final StringBuilder charSequence = new StringBuilder("nominal");
        final SimpleMessage message = new SimpleMessage(charSequence);
        assertEquals("nominal",message.getFormat());
    }

    @Test
    public void get_parameter(){
        final StringBuilder charSequence = new StringBuilder("nominal");
        final SimpleMessage message = new SimpleMessage(charSequence);
        assertEquals(null,message.getParameters());
    }


}
