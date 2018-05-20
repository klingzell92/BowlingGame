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
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(100, g.getGameSum());

    }

       /**
     * Test that a game with a spare returns the correct sum
     */
    public void testGameSumWithSpare(){
        // US 6
        Game g = new Game();
        Frame frame = new Frame();

        // Fill the game with a spare first and the rest with 9s
        frame.add(9);
        frame.add(1);
        g.addFrame(frame);
        for (int i = 0; i < 9; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(97, g.getGameSum());

    }
      /**
     * Test that a game with a strike and a spare returns the correct sum
     */
    public void testGameSumWithSpareAndStrike(){
        // US 7
        Game g = new Game();
        Frame frame = new Frame();

        // Fill the game with a spare first and then a strike and the rest with 9s
        frame.add(9);
        frame.add(1);
        g.addFrame(frame);
        frame = new Frame();
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        for (int i = 0; i < 8; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        System.out.print(g.getGameSum() + "\n");
        assertEquals(111, g.getGameSum());
 
        // Fill the game with a spare first and then a strike and the rest with 9s
        g = new Game();
        frame = new Frame();
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        frame = new Frame();
        frame.add(9);
        frame.add(1);
        g.addFrame(frame);
        for (int i = 0; i < 8; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(108, g.getGameSum());

    }
    /**
     * Test that a game with multiple strikes returns the correct sum
     */
    public void testGameSumWithMultipleStrikes(){
        // US 8
        Game g = new Game();
        Frame frame = new Frame();

        // Fill the game with a spare first and the rest with 9s
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        frame = new Frame();
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        for (int i = 0; i < 8; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(117, g.getGameSum());
    }

        /**
     * Test that a game with multiple strikes returns the correct sum
     */
    public void testGameSumWithMultipleSpares(){
        // US 9
        Game g = new Game();
        Frame frame = new Frame();

        // Fill the game with two spares at first and the rest with 9s
        frame.add(8);
        frame.add(2);
        g.addFrame(frame);
        frame = new Frame();
        frame.add(5);
        frame.add(5);
        g.addFrame(frame);
        for (int i = 0; i < 8; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }

        // Check that the total sum is correct
        assertEquals(103, g.getGameSum());
    }

}
