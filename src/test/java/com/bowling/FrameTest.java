package com.bowling;

import junit.framework.Test;
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
        assertEquals(0, testFrame.tries.size());
        
        testFrame.addResult(1);

        assertEquals(1, testFrame.tries.size());

        testFrame.addResult(5);

        // A frame consists of 2 tries after one round        
        assertEquals(2, testFrame.tries.size());
    }
}
