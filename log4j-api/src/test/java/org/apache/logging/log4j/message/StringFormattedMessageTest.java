/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.message;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;

import org.apache.logging.log4j.junit.Mutable;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class StringFormattedMessageTest {

    private static final int LOOP_CNT = 500;
    String[] array = new String[LOOP_CNT];

    @Test
    public void testNoArgs() {
        final String testMsg = "Test message %1s";
        StringFormattedMessage msg = new StringFormattedMessage(testMsg, (Object[]) null);
        String result = msg.getFormattedMessage();
        final String expected = "Test message null";
        assertEquals(expected, result);
        final Object[] array = null;
        msg = new StringFormattedMessage(testMsg, array, null);
        result = msg.getFormattedMessage();
        assertEquals(expected, result);
    }

    @Test
    public void testOneStringArg() {
        final String testMsg = "Test message %1s";
        final StringFormattedMessage msg = new StringFormattedMessage(testMsg, "Apache");
        final String result = msg.getFormattedMessage();
        final String expected = "Test message Apache";
        assertEquals(expected, result);
    }

    @Test
    public void testOneIntArgLocaleUs() {
        final String testMsg = "Test e = %+10.4f";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.US, testMsg, Math.E);
        final String result = msg.getFormattedMessage();
        final String expected = "Test e =    +2.7183";
        assertEquals(expected, result);
    }

    @Test
    public void testENStringGetFormattedMessage() {
        final String testMsg = "%s";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, "hello");
        final String result = msg.getFormattedMessage();
        assertEquals(result, "hello");
    }

    @Test
    public void testENStringGetThrowable() {
        final String testMsg = "%s";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, "hello");
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testFRStringGetFormattedMessage() {
        final String testMsg = "%s";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, "amour");
        final String result = msg.getFormattedMessage();
        assertEquals(result, "amour");
    }

    @Test
    public void testFRStringGetThrowable() {
        final String testMsg = "%s";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, "amour");
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testENCharacterGetFormattedMessage() {
        final String testMsg = "%c";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, 'c');
        final String result = msg.getFormattedMessage();
        assertEquals(result, "c");
    }

    @Test
    public void testENCharacterGetThrowable() {
        final String testMsg = "%c";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, 'c');
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testFRCharacterGetFormattedMessage() {
        final String testMsg = "%c";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, 'c');
        final String result = msg.getFormattedMessage();
        assertEquals(result, "c");
    }

    @Test
    public void testFRCharacterGetThrowable() {
        final String testMsg = "%c";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.ENGLISH, testMsg, 'c');
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testENIntegerGetFormattedMessage() {
        final String testMsg = "%d";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, 1);
        final String result = msg.getFormattedMessage();
        assertEquals(result, "1");
    }

    @Test
    public void testENIntegerGetThrowable() {
        final String testMsg = "%d";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, 1);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }


    @Test
    public void testFRIntegerGetFormattedMessage() {
        final String testMsg = "%d";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, 1);
        final String result = msg.getFormattedMessage();
        assertEquals(result, "1");
    }

    @Test
    public void testFRIntegerGetThrowable() {
        final String testMsg = "%d";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRENCH, testMsg, 1);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testZHExceptionGetThrowable() {
        final String testMsg = "%s";
        final Exception exc = new Exception("Exception");
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.CHINESE, testMsg, exc);
        final Object result = msg.getFormattedMessage();
        assertTrue(result.equals("java.lang.Exception: Exception") );
    }

    @Test
    public void testZHExceptionGetFormattedMessage() {
        final String testMsg = "%s";
        final Exception exc = new Exception("Exception");
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.CHINESE, testMsg, exc);
        final Object result = msg.getThrowable();
        assertTrue(result == exc);
    }

    @Test
    public void testOneArgLocaleFrance() {
        final String testMsg = "Test e = %+10.4f";
        final StringFormattedMessage msg = new StringFormattedMessage(Locale.FRANCE, testMsg, Math.E);
        final String result = msg.getFormattedMessage();
        final String expected = "Test e =    +2,7183";
        assertEquals(expected, result);
    }

    @Test
    public void testException() {
        final String testMsg = "Test message {0}";
        final MessageFormatMessage msg = new MessageFormatMessage(testMsg, "Apache", new NullPointerException("Null"));
        final String result = msg.getFormattedMessage();
        final String expected = "Test message Apache";
        assertEquals(expected, result);
        final Throwable t = msg.getThrowable();
        assertNotNull("No Throwable", t);
    }

    @Test
    public void testUnsafeWithMutableParams() { // LOG4J2-763
        final String testMsg = "Test message %s";
        final Mutable param = new Mutable().set("abc");
        final StringFormattedMessage msg = new StringFormattedMessage(testMsg, param);

        // modify parameter before calling msg.getFormattedMessage
        param.set("XYZ");
        final String actual = msg.getFormattedMessage();
        assertEquals("Should use initial param value", "Test message XYZ", actual);
    }

    @Test
    public void testSafeAfterGetFormattedMessageIsCalled() { // LOG4J2-763
        final String testMsg = "Test message %s";
        final Mutable param = new Mutable().set("abc");
        final StringFormattedMessage msg = new StringFormattedMessage(testMsg, param);

        // modify parameter after calling msg.getFormattedMessage
        msg.getFormattedMessage();
        param.set("XYZ");
        final String actual = msg.getFormattedMessage();
        assertEquals("Should use initial param value", "Test message abc", actual);
    }

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        final StringFormattedMessage expected = new StringFormattedMessage("Msg", "a", "b", "c");
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (final ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeObject(expected);
        }
        final ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        final ObjectInputStream in = new ObjectInputStream(bais);
        final StringFormattedMessage actual = (StringFormattedMessage) in.readObject();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.getFormat(), actual.getFormat());
        Assert.assertEquals(expected.getFormattedMessage(), actual.getFormattedMessage());
        Assert.assertArrayEquals(expected.getParameters(), actual.getParameters());
    }



}
