package org.apache.logging.log4j.message;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;


public class MyFormattedMessageTest {

    String targetString = "Test 4 ParameterizedMessage patterns";

    String parameterizedPattern = "Test {} ParameterizedMessage {}";
    String messageFormatPattern = "Test {0} ParameterizedMessage {1}";
    String stringFormatPattern = "Test %d ParameterizedMessage %s";

    Object[] arguments = {4, "patterns"};
    Object[] oneArgument = {4};
    Object[] threeArguments = {4, "patterns", 5};

    Throwable throwable = new Throwable();

    Message nominal;
    Message nullLocale;
    Message nonExistLocal;
    Message nullPattern;
    Message messagePattern;
    Message stringPattern;
    Message nullArguments;
    Message lessArguments;
    Message moreArguments;
    Message nullThrowable;

    @Before
    public void setUp() {
        nominal = new FormattedMessage(Locale.US, parameterizedPattern, arguments, throwable);
        nullLocale = new FormattedMessage(null, parameterizedPattern, arguments, throwable);
        nonExistLocal = new FormattedMessage(new Locale("wwww"), parameterizedPattern, arguments, throwable);
        nullPattern = new FormattedMessage(Locale.US, null, arguments, throwable);
        messagePattern = new FormattedMessage(Locale.US, messageFormatPattern, arguments, throwable);
        stringPattern = new FormattedMessage(Locale.US, stringFormatPattern, arguments, throwable);
        nullArguments = new FormattedMessage(Locale.US, parameterizedPattern, null, throwable);
        lessArguments = new FormattedMessage(Locale.US, parameterizedPattern, oneArgument, throwable);
        moreArguments = new FormattedMessage(Locale.US, parameterizedPattern, threeArguments, throwable);
        nullThrowable = new FormattedMessage(Locale.US, parameterizedPattern, arguments, null);
    }

    @Test
    public void nominalCanGetFormattedMessage() {
        assertEquals(targetString, nominal.getFormattedMessage());
    }

    @Test
    public void nominalCanGetFormat() {
        assertEquals(parameterizedPattern, nominal.getFormat());
    }

    @Test
    public void nominalCanGetParameters() {
        assertEquals(arguments, nominal.getParameters());
    }

    @Test
    public void nominalCanGetThrowable() {
        assertEquals(throwable, nominal.getThrowable());
    }

    @Test
    public void nullLocalCanGetFormattedMessage() {
        assertEquals(targetString, nullLocale.getFormattedMessage());
    }

    @Test
    public void nullLocalCanGetFormat() {
        assertEquals(parameterizedPattern, nullLocale.getFormat());
    }

    @Test
    public void nullLocalCanGetParameters() {
        assertEquals(arguments, nullLocale.getParameters());
    }

    @Test
    public void nullLocalCanGetThrowable() {
        assertEquals(throwable, nullLocale.getThrowable());
    }

    @Test
    public void nonExistLocalCanGetFormattedMessage() {
        assertEquals(targetString, nonExistLocal.getFormattedMessage());
    }

    @Test
    public void nonExistLocalCanGetFormat() {
        assertEquals(parameterizedPattern, nonExistLocal.getFormat());
    }

    @Test
    public void nonExistLocalCanGetParameters() {
        assertEquals(arguments, nonExistLocal.getParameters());
    }

    @Test
    public void nonExistLocalCanGetThrowable() {
        assertEquals(throwable, nonExistLocal.getThrowable());
    }

    @Test
    public void nullPatternCannotGetFormattedMessage() {
        assertEquals(null, nullPattern.getFormattedMessage());
    }

    @Test
    public void nullPatternCanGetFormat() {
        assertEquals(null, nullPattern.getFormat());
    }

    @Test
    public void nullPatternCanGetParameters() {
        assertEquals(arguments, nullPattern.getParameters());
    }

    @Test
    public void nullPatternCanGetThrowable() {
        assertEquals(throwable, nullPattern.getThrowable());
    }

    @Test
    public void messagePatternCanGetFormattedMessage() {
        assertEquals(targetString, messagePattern.getFormattedMessage());
    }

    @Test
    public void messagePatternCanGetFormat() {
        assertEquals(messageFormatPattern, messagePattern.getFormat());
    }

    @Test
    public void messagePatternCanGetParameters() {
        assertEquals(arguments, messagePattern.getParameters());
    }

    @Test
    public void messagePatternCanGetThrowable() {
        assertEquals(throwable, messagePattern.getThrowable());
    }

    @Test
    public void stringPatternCanGetFormattedMessage() {
        assertEquals(targetString, stringPattern.getFormattedMessage());
    }

    @Test
    public void stringPatternCanGetFormat() {
        assertEquals(stringFormatPattern, stringPattern.getFormat());
    }

    @Test
    public void stringPatternCanGetParameters() {
        assertEquals(arguments, stringPattern.getParameters());
    }

    @Test
    public void stringPatternCanGetThrowable() {
        assertEquals(throwable, stringPattern.getThrowable());
    }

    @Test
    public void nullArgumentsCanGetFormattedMessage() {
        assertEquals("Test {} ParameterizedMessage {}", nullArguments.getFormattedMessage());
    }

    @Test
    public void nullArgumentsCanGetFormat() {
        assertEquals(parameterizedPattern, nullArguments.getFormat());
    }

    @Test
    public void nullArgumentsCanGetParameters() {
        assertEquals(null, nullArguments.getParameters());
    }

    @Test
    public void nullArgumentsCanGetThrowable() {
        assertEquals(throwable, nullArguments.getThrowable());
    }

    @Test
    public void lessArgumentsCanGetFormattedMessage() {
        assertEquals("Test 4 ParameterizedMessage {}", lessArguments.getFormattedMessage());
    }

    @Test
    public void lessArgumentsCanGetFormat() {
        assertEquals(parameterizedPattern, lessArguments.getFormat());
    }

    @Test
    public void lessArgumentsCanGetParameters() {
        assertEquals(oneArgument, lessArguments.getParameters());
    }

    @Test
    public void lessArgumentsCanGetThrowable() {
        assertEquals(throwable, lessArguments.getThrowable());
    }

    @Test
    public void moreArgumentsCanGetFormattedMessage() {
        assertEquals(targetString, moreArguments.getFormattedMessage());
    }

    @Test
    public void moreArgumentsCanGetFormat() {
        assertEquals(parameterizedPattern, moreArguments.getFormat());
    }

    @Test
    public void moreArgumentsCanGetParameters() {
        assertEquals(threeArguments, moreArguments.getParameters());
    }

    @Test
    public void moreArgumentsCanGetThrowable() {
        assertEquals(throwable, moreArguments.getThrowable());
    }

    @Test
    public void nullThrowableCanGetFormattedMessage() {
        assertEquals(targetString, nullThrowable.getFormattedMessage());
    }

    @Test
    public void nullThrowableCanGetFormat() {
        assertEquals(parameterizedPattern, nullThrowable.getFormat());
    }

    @Test
    public void nullThrowableCanGetParameters() {
        assertEquals(arguments, nullThrowable.getParameters());
    }

    @Test
    public void nullThrowableCanGetThrowable() {
        assertEquals(null, nullThrowable.getThrowable());
    }
}
