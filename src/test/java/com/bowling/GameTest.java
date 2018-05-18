package com.bowling;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.util.Random;

/**
 * Unit test for Game.
 */
public class GameTest extends TestCase {
    public void testGame() {
        Game g = new Game();

        // Add 10 frames to the game
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame();
            frame.add(new Random().nextInt(10));
            frame.add(new Random().nextInt(10));
            g.addFrame(frame);

        }

        // make sure game has 10 frames
        int size = g.gameFrames.size();
        assertEquals(10, size);

        // make sure each frame consists of 2 throw results
        for (Frame f : g.gameFrames) {
            int frameScoreSize = f.size();
            assertEquals(2, frameScoreSize);
        }
    }
}
