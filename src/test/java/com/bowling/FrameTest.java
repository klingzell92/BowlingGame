package com.bowling;

import junit.framework.TestCase;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class FrameTest extends TestCase {
    /**
     * Test that Frame size works correctly
     */
    public void testFrameSize() {
        Frame testFrame = new Frame();

        // A frame consists of 0 tries at the beginning
        assertEquals(0, testFrame.size());
        
        testFrame.add(1);

        assertEquals(1, testFrame.size());

        testFrame.add(5);

        // A frame consists of 2 tries after one round        
        assertEquals(2, testFrame.size());

        // Make sure items are not added
        testFrame.add(5);
        testFrame.add(5);
        testFrame.add(5);

        // Make sure size is still 2 and consists of added items
        assertEquals(2, testFrame.size());
        assertEquals(1, testFrame.get(0));
        assertEquals(5, testFrame.get(1));
    }
}
