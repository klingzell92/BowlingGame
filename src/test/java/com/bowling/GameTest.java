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

    public void testGameSum() {
        // US 4 - test compute score of the Game
        Game g = new Game();

        // Fill game with zeros
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame();
            frame.add(0);
            frame.add(0);
            g.addFrame(frame);
        }

        // Compute total sum of the game
        assertEquals(0, g.getGameSum());

        // Fill the game with 10s this time

        g = new Game();

        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame();
            frame.add(10);
            frame.add(10);
            g.addFrame(frame);
        }

        // Compute total sum of the game
        assertEquals(200, g.getGameSum());
    }
}
