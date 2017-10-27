package org.apache.logging.log4j.message;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by joekr on 10/22/17.
 */
public class MyLocalizedMessageTest {
    LocalizedMessage nominal;
    LocalizedMessage base_non_valid;
    LocalizedMessage null_locale;
    LocalizedMessage invalid_locale;
    LocalizedMessage null_key;
    LocalizedMessage invalid_key;
    @Before
    public void setUp(){
        nominal = new LocalizedMessage("MF", new Locale("en", "US"), "msg1", new Object[] { "1", "Test" });
        base_non_valid = new LocalizedMessage("F", new Locale("en", "US"), "msg1", new Object[] { "1", "Test" });
        null_locale = new LocalizedMessage("MF", (Locale)null, "msg1", new Object[] { "1", "Test" });
        invalid_locale = new LocalizedMessage("MF", new Locale("en", "US"), "msg1", new Object[] { "1", "Test" });
        null_key = new LocalizedMessage("MF", new Locale("en", "US"),null, new Object[] { "1", "Test" });
        invalid_key = new LocalizedMessage("MF", new Locale("en", "US"),"msg100", new Object[] { "1", "Test" });
    }

    @Test
    public void testNominalMessageFormat() {
        assertEquals("This is test number 1 with string argument Test.", nominal.getFormattedMessage());
    }

    @Test
    public void testBaseNonValidMessageFormat() {
        assertEquals("msg1", base_non_valid.getFormattedMessage());
    }

    @Test
    public void testNulLocaleMessageFormat(){
        assertEquals("This is test number 1 with string argument Test.",null_locale.getFormattedMessage());
    }

    @Test
    public void testInvalidLocaleMessageFormat(){
        assertEquals("This is test number 1 with string argument Test.",null_locale.getFormattedMessage());
    }

    @Test (expected = NullPointerException.class)
    public void testNullKeyMessageFormat(){
        assertEquals("This is test number 1 with string argument Test.",null_key.getFormattedMessage());
    }

    @Test
    public void testInvalidKeyMessageFormat(){
        assertEquals("msg100",invalid_key.getFormattedMessage());
    }

    @Test
    public void get_format(){
        assertEquals("msg1",nominal.getFormat());
    }

    @Test
    public void get_throwable(){
        assertEquals(null,nominal.getThrowable());
    }

    @Test
    public void get_parameters(){
        assertEquals(new Object[] { "1", "Test" }, nominal.getParameters());
    }








}
