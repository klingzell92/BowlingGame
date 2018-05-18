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

        // Fill the game with 9s this time

        g = new Game();

        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Compute total sum of the game
        assertEquals(90, g.getGameSum());
    }

    /**
     * Test that a game with a strike returns the correct sum
     */
    public void testGameSumWithStrike(){
        // US 5
        Game g = new Game();
        Frame frame = new Frame();

        // Fill the game with a strike first and the rest with 9s
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        for (int i = 0; i < 9; i++) {
            frame = new Frame();
            frame.add(10);
            frame.add(0);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(100, g.getGameSum());

    }
}
