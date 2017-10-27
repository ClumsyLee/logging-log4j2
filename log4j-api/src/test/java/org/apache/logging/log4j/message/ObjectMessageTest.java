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

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.logging.log4j.junit.Mutable;
import org.apache.logging.log4j.junit.SerialUtil;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests {@link ObjectMessage}.
 */
public class ObjectMessageTest {

    @Test
    public void testNull() {
        final ObjectMessage msg = new ObjectMessage(null);
        final String result = msg.getFormattedMessage();
        assertEquals("null", result);
    }


    @Test
    public void testStringGetFormat() {
        final ObjectMessage msg = new ObjectMessage("HelloWorld");
        final String result = msg.getFormat();
        assertEquals("HelloWorld", result);

    }

    @Test
    public void testStringGetParameter() {
        final ObjectMessage msg = new ObjectMessage("HelloWorld");
        final Object[] result = msg.getParameters();
        assertEquals((String)result[0], "HelloWorld");
        assertEquals(1, result.length);
    }

    @Test
    public void testStringGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage("HelloWorld");
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("HelloWorld"));
    }

    @Test
    public void testStringGetThrowable() {
        final ObjectMessage msg = new ObjectMessage("HelloWorld");
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testCharacterGetFormat() {
        final ObjectMessage msg = new ObjectMessage('C');
        final String result = msg.getFormat();
        assertEquals("C", result);

    }

    @Test
    public void testCharacterGetParameter() {
        final ObjectMessage msg = new ObjectMessage('C');
        final Object[] result = msg.getParameters();
        assertEquals((char)result[0], 'C');
        assertEquals(1, result.length);
    }

    @Test
    public void testCharacterGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage('C');
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("C"));
    }

    @Test
    public void testCharacterGetThrowable() {
        final ObjectMessage msg = new ObjectMessage('C');
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testNullGetFormat() {
        final ObjectMessage msg = new ObjectMessage(null);
        final String result = msg.getFormat();
        assertEquals("null", result);

    }

    @Test
    public void testNullGetParameter() {
        final ObjectMessage msg = new ObjectMessage(null);
        final Object[] result = msg.getParameters();
        assertEquals((String)result[0], "null");
        assertEquals(1, result.length);
    }

    @Test
    public void testNullGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage(null);
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("null"));
    }

    @Test
    public void testNullGetThrowable() {
        final ObjectMessage msg = new ObjectMessage(null);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testIntegerGetFormat() {
        final ObjectMessage msg = new ObjectMessage(101);
        final String result = msg.getFormat();
        assertEquals("101", result);

    }

    @Test
    public void testIntegerGetParameter() {
        final ObjectMessage msg = new ObjectMessage(101);
        final Object[] result = msg.getParameters();
        assertEquals((int)result[0], 101);
        assertEquals(1, result.length);
    }

    @Test
    public void testIntegerGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage(101);
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("101"));
    }

    @Test
    public void testIntegerGetThrowable() {
        final ObjectMessage msg = new ObjectMessage(101);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }


    @Test
    public void testFloatGetFormat() {
        final ObjectMessage msg = new ObjectMessage(1.2);
        final String result = msg.getFormat();
        assertEquals("1.2", result);

    }

    @Test
    public void testFloatGetParameter() {
        final ObjectMessage msg = new ObjectMessage((float)1.2);
        final Object[] result = msg.getParameters();
        assertEquals((float)result[0], (float)1.2, 0.01);
        assertEquals(1, result.length);
    }

    @Test
    public void testFloatGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage((float)1.2);
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("1.2"));
    }

    @Test
    public void testFloatGetThrowable() {
        final ObjectMessage msg = new ObjectMessage((float)1.2);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }

    @Test
    public void testLongGetFormat() {
        final ObjectMessage msg = new ObjectMessage(980L);
        final String result = msg.getFormat();
        assertEquals("980", result);

    }

    @Test
    public void testLongGetParameter() {
        final ObjectMessage msg = new ObjectMessage(980L);
        final Object[] result = msg.getParameters();
        assertEquals(980L, (long)result[0]);
        assertEquals(1, result.length);
    }

    @Test
    public void testLongGetFormattedMessage() {
        final ObjectMessage msg = new ObjectMessage(980L);
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("980"));
    }

    @Test
    public void testLongGetThrowable() {
        final ObjectMessage msg = new ObjectMessage(980l);
        final Object result = msg.getThrowable();
        assertTrue(result == null);
    }


    @Test
    public void testExceptionGetFormat() {
        Exception exc = new Exception("Exception");
        final ObjectMessage msg = new ObjectMessage(exc);
        final String result = msg.getFormat();
        assertEquals(msg.toString(), result);

    }

    @Test
    public void testExceptionGetParameter() {
        Exception exc = new Exception("Exception");
        final ObjectMessage msg = new ObjectMessage(exc);
        final Object result = msg.getParameter();
        assertTrue(result == exc);
        assertEquals(exc.hashCode(), result.hashCode());
    }

    @Test
    public void testExceptionGetFormattedMessage() {
        Exception exc = new Exception("Exception");
        final ObjectMessage msg = new ObjectMessage(exc);
        final String result = msg.getFormattedMessage();
        assertTrue(result.equals("java.lang.Exception: Exception"));

    }

    @Test
    public void testExceptionGetThrowable() {
        Exception exc = new Exception("Exception");
        final ObjectMessage msg = new ObjectMessage(exc);
        final Object result = msg.getThrowable();
        assertTrue(result == exc);
    }

    @Test
    public void testNotNull() {
        final String testMsg = "Test message {}";
        final ObjectMessage msg = new ObjectMessage(testMsg);
        final String result = msg.getFormattedMessage();
        assertEquals(testMsg, result);
    }

    @Test
    public void testUnsafeWithMutableParams() { // LOG4J2-763
        final Mutable param = new Mutable().set("abc");
        final ObjectMessage msg = new ObjectMessage(param);

        // modify parameter before calling msg.getFormattedMessage
        param.set("XYZ");
        final String actual = msg.getFormattedMessage();
        assertEquals("Expected most recent param value", "XYZ", actual);
    }

    @Test
    public void testSafeAfterGetFormattedMessageIsCalled() { // LOG4J2-763
        final Mutable param = new Mutable().set("abc");
        final ObjectMessage msg = new ObjectMessage(param);

        // modify parameter after calling msg.getFormattedMessage
        msg.getFormattedMessage();
        param.set("XYZ");
        final String actual = msg.getFormattedMessage();
        assertEquals("Should use initial param value", "abc", actual);
    }

    @Test
    public void testSerializeWithSerializableParam() {
        final BigDecimal big = BigDecimal.valueOf(123.456);
        final ObjectMessage msg = new ObjectMessage(big);
        final ObjectMessage other = SerialUtil.deserialize(SerialUtil.serialize(msg));
        assertEquals(msg, other);
    }

    @Test
    public void testDeserializeNonSerializableParamEqualIfToStringSame() {
        class NonSerializable {
            @Override
            public boolean equals(final Object other) {
                return other instanceof NonSerializable; // a very lenient equals()
            }
        }
        final NonSerializable nonSerializable = new NonSerializable();
        assertFalse(nonSerializable instanceof Serializable);
        final ObjectMessage msg = new ObjectMessage(nonSerializable);
        final ObjectMessage other = SerialUtil.deserialize(SerialUtil.serialize(msg));

        assertEquals(msg, other);
        assertEquals(other, msg);
    }

    @Test
    public void formatTo_usesCachedMessageString() throws Exception {
        final StringBuilder charSequence = new StringBuilder("initial value");
        final ObjectMessage message = new ObjectMessage(charSequence);
        assertEquals("initial value", message.getFormattedMessage());

        charSequence.setLength(0);
        charSequence.append("different value");

        final StringBuilder result = new StringBuilder();
        message.formatTo(result);
        assertEquals("initial value", result.toString());
    }
}
