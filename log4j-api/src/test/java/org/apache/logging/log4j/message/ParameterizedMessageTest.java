package org.apache.logging.log4j.message;

import org.apache.logging.log4j.junit.Mutable;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.junit.Test;

import static org.junit.Assert.*;


public class ParameterizedMessageTest {

    @Test
    public void testWellFormedMessagePatternAndNominalArgs() {
        final String testMsg = "Test message {}{} {}";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c", result);
    }

    @Test
    public void testWellFormedMessagePatternAndNoArgs() {
        final String testMsg = "Test message {}";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, null);
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testWellFormedMessagePatternAndZeroLengthArgs() {
        final String testMsg = "";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, new String[]{"arg"});
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testWellFormedMessagePatternAndOneCharLengthArgs() {
        final String testMsg = "d";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, new String[]{"arg"});
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }



    @Test
    public void testWellFormedMessagePatternAndNullArgs() {
        final String testMsg = "Test message {} {} {} {} {} {}";
        final String[] args = { "a", null, "c", null, null, null };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message a null c null null null", result);
    }

    @Test
    public void testWellFormedMessagePatternAndSuperfluousArgs() {
        final String testMsg = "Test message {}{} {}";
        final String[] args = { "a", "b", "c", "unnecessary", "superfluous" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c", result);
    }

    @Test
    public void testWellFormedMessagePatternAndArgsWithEscape() {
        final String testMsg = "Test message \\{}{} {}";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message {}a b", result);
    }

    @Test
    public void testFormatStringArgsWithTrailingEscape() {
        final String testMsg = "Test message {}{} {}\\";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c\\", result);
    }

    @Test
    public void testFormatStringArgsWithTrailingText() {
        final String testMsg = "Test message {}{} {}Text";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab cText", result);
    }

    @Test
    public void testFormatStringArgsWithTrailingEscapedEscape() {
        final String testMsg = "Test message {}{} {}\\\\";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c\\\\", result);
    }

    @Test
    public void testFormatStringArgsWithEscapedEscape() {
        final String testMsg = "Test message \\\\{}{} {}";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message \\ab c", result);
    }

    @Test
    public void testNoArgs() {
        final String testMsg = "Test message {}";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, null);
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testZeroLength() {
        final String testMsg = "";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, new String[]{"arg"});
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testOneCharLength() {
        final String testMsg = "d";
        ParameterizedMessage msg = new ParameterizedMessage(testMsg, new String[]{"arg"});
        String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
        final Object[] array = null;
        msg = new ParameterizedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testFormat3StringArgs() {
        final String testMsg = "Test message {}{} {}";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c", result);
    }

    @Test
    public void testFormatNullArgs() {
        final String testMsg = "Test message {} {} {} {} {} {}";
        final String[] args = { "a", null, "c", null, null, null };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message a null c null null null", result);
    }

    @Test
    public void testFormatStringArgsIgnoresSuperfluousArgs() {
        final String testMsg = "Test message {}{} {}";
        final String[] args = { "a", "b", "c", "unnecessary", "superfluous" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message ab c", result);
    }

    @Test
    public void testFormatStringArgsWithEscape() {
        final String testMsg = "Test message \\{}{} {}";
        final String[] args = { "a", "b", "c" };
        final String result = ParameterizedMessage.format(testMsg, args);
        assertEquals("Test message {}a b", result);
    }



    @Test
    public void testSafeWithMutableParams() { // LOG4J2-763
        final String testMsg = "Test message {}";
        final Mutable param = new Mutable().set("abc");
        final ParameterizedMessage msg = new ParameterizedMessage(testMsg, param);

        // modify parameter before calling msg.getFormattedMessage
        param.set("XYZ");
        final String actual = msg.getFormattedMessage();
        assertEquals("Should use current param value", "Test message XYZ", actual);

        // modify parameter after calling msg.getFormattedMessage
        param.set("000");
        final String after = msg.getFormattedMessage();
        assertEquals("Should not change after rendered once", "Test message XYZ", after);
    }

}
