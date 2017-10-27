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

import org.junit.Assert;
import org.junit.Test;

/**
 * @since 2.4
 */
public class ObjectArrayMessageTest {
    
    private Object[] array;
    private ObjectArrayMessage objectArrayMessage;

    @Test
    public void testNullArray() {
        array = null;               
        objectArrayMessage = new ObjectArrayMessage(array);
        
        Assert.assertArrayEquals(new Object[0], objectArrayMessage.getParameters());
        Assert.assertEquals("[]", objectArrayMessage.getFormat());
        Assert.assertEquals("[]", objectArrayMessage.getFormattedMessage());
        Assert.assertNull(objectArrayMessage.getThrowable());
    }

    @Test
    public void testEmptyArray() {
        array = new Object[0];  
        objectArrayMessage = new ObjectArrayMessage(array);
        
        Assert.assertArrayEquals(new Object[0], objectArrayMessage.getParameters());
        Assert.assertEquals("[]", objectArrayMessage.getFormat());
        Assert.assertEquals("[]", objectArrayMessage.getFormattedMessage());
        Assert.assertNull(objectArrayMessage.getThrowable());
    }
    
    @Test
    public void testOneElementArray() {
        array = new Object[]{"a"};
        objectArrayMessage = new ObjectArrayMessage(array);
        
        Assert.assertArrayEquals(new Object[]{"a"}, objectArrayMessage.getParameters());
        Assert.assertEquals("[a]", objectArrayMessage.getFormat());
        Assert.assertEquals("[a]", objectArrayMessage.getFormattedMessage());
        Assert.assertNull(objectArrayMessage.getThrowable());
    }
    
    @Test
    public void testTwoElementsArray() {
        array = new Object[]{"a","b"};
        objectArrayMessage = new ObjectArrayMessage(array);
        
        Assert.assertArrayEquals(new Object[]{"a","b"}, objectArrayMessage.getParameters());
        Assert.assertEquals("[a, b]", objectArrayMessage.getFormat());
        Assert.assertEquals("[a, b]", objectArrayMessage.getFormattedMessage());
        Assert.assertNull(objectArrayMessage.getThrowable());
    }
    
    @Test
    public void testThreeElementsArray() {
        array = new Object[]{"a","b", "c"};
        objectArrayMessage = new ObjectArrayMessage(array);
        
        Assert.assertArrayEquals(new Object[]{"a","b","c"}, objectArrayMessage.getParameters());
        Assert.assertEquals("[a, b, c]", objectArrayMessage.getFormat());
        Assert.assertEquals("[a, b, c]", objectArrayMessage.getFormattedMessage());
        Assert.assertNull(objectArrayMessage.getThrowable());
    }

    @Test
    public void testNullArrayMessageConstuctor() {
        array = null;
        objectArrayMessage = new ObjectArrayMessage(array);

        Assert.assertArrayEquals(new Object[0], objectArrayMessage.getParameters());
    }

    @Test
    public void testGetFormat() {
        array = new Object[] { 1, 2, 3 };
        objectArrayMessage = new ObjectArrayMessage(array);
        Assert.assertEquals("[1, 2, 3]", objectArrayMessage.getFormat());
    }
    
    @Test
    public void testGetFormattedMessageWithNullArray() {
        array = null;
        objectArrayMessage = new ObjectArrayMessage(array);
        Assert.assertEquals("[]", objectArrayMessage.getFormattedMessage());
    }
    
    @Test
    public void testGetFormattedMessageWithNormalArray() {
        array = new Object[] { 1, 2, 3 };
        objectArrayMessage = new ObjectArrayMessage(array);
        Assert.assertEquals("[1, 2, 3]", objectArrayMessage.getFormattedMessage());
    }
    
    @Test
    public void testGetParameters() {
        array = new Object[] { 1, 2, 3 };
        objectArrayMessage = new ObjectArrayMessage(array);
        Assert.assertArrayEquals(array, objectArrayMessage.getParameters());
    }

    @Test
    public void testGetThrowable() {
        array = new Object[] { 1, 2, 3 };
        objectArrayMessage = new ObjectArrayMessage(array);
        Assert.assertEquals(null, objectArrayMessage.getThrowable());
    }

}
