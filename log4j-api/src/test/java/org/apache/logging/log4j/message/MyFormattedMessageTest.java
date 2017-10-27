package org.apache.logging.log4j.message;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;

import java.util.Locale;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

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

    ParameterizedMessageFactory factoryMock;
    Message messageMock;

    @Before
    public void setUp() {
        factoryMock = mock(ParameterizedMessageFactory.class);
        messageMock = mock(Message.class);

        nominal = new FormattedMessage(Locale.US, parameterizedPattern, arguments, throwable, factoryMock);
        nullLocale = new FormattedMessage((Locale) null, parameterizedPattern, arguments, throwable, factoryMock);
        nonExistLocal = new FormattedMessage(new Locale("wwww"), parameterizedPattern, arguments, throwable, factoryMock);
        nullPattern = new FormattedMessage(Locale.US, null, arguments, throwable, factoryMock);
        messagePattern = new FormattedMessage(Locale.US, messageFormatPattern, arguments, throwable);
        stringPattern = new FormattedMessage(Locale.US, stringFormatPattern, arguments, throwable);
        nullArguments = new FormattedMessage(Locale.US, parameterizedPattern, null, throwable, factoryMock);
        lessArguments = new FormattedMessage(Locale.US, parameterizedPattern, oneArgument, throwable, factoryMock);
        moreArguments = new FormattedMessage(Locale.US, parameterizedPattern, threeArguments, throwable, factoryMock);
        nullThrowable = new FormattedMessage(Locale.US, parameterizedPattern, arguments, null, factoryMock);
    }

    @Test
    public void nominalCanGetFormattedMessage() {
        when(factoryMock.newMessage(parameterizedPattern, arguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(targetString);

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
        when(factoryMock.newMessage(parameterizedPattern, arguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(targetString);

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
        when(factoryMock.newMessage(parameterizedPattern, arguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(targetString);

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
        when(factoryMock.newMessage(null, arguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(null);

        assertNull(nullPattern.getFormattedMessage());
    }

    @Test
    public void nullPatternCanGetFormat() {
        assertNull(nullPattern.getFormat());
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
        String result = "Test {} ParameterizedMessage {}";

        when(factoryMock.newMessage(parameterizedPattern, arguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(result);

        assertEquals(result, nullArguments.getFormattedMessage());
    }

    @Test
    public void nullArgumentsCanGetFormat() {
        assertEquals(parameterizedPattern, nullArguments.getFormat());
    }

    @Test
    public void nullArgumentsCanGetParameters() {
        assertNull(nullArguments.getParameters());
    }

    @Test
    public void nullArgumentsCanGetThrowable() {
        assertEquals(throwable, nullArguments.getThrowable());
    }

    @Test
    public void lessArgumentsCanGetFormattedMessage() {
        String result = "Test 4 ParameterizedMessage {}";

        when(factoryMock.newMessage(parameterizedPattern, oneArgument, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(result);

        assertEquals(result, lessArguments.getFormattedMessage());
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
        when(factoryMock.newMessage(parameterizedPattern, threeArguments, throwable)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(targetString);

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
        when(factoryMock.newMessage(parameterizedPattern, arguments, null)).thenReturn(messageMock);
        when(messageMock.getFormattedMessage()).thenReturn(targetString);

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
        when(factoryMock.newMessage(parameterizedPattern, arguments, null)).thenReturn(messageMock);
        when(messageMock.getThrowable()).thenReturn(null);

        assertNull(nullThrowable.getThrowable());
    }
}
