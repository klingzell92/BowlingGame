package com.bowling;

import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.util.ArrayList;
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

    /** 
    * Test that a game with multiple strikes returns the correct sum
    */
   public void testGameSumWithSpareAsLastFrame(){
       // US 10
       Game g = new Game();
       Frame frame = new Frame();

       // Fill the game with a spare as the last frame and a bonus throw
       frame.add(8);
       frame.add(2);
       g.addFrame(frame);
       for (int i = 0; i < 8; i++) {
           frame = new Frame();
           frame.add(6);
           frame.add(3);
           g.addFrame(frame);
       }
       frame = new Frame();
       frame.add(5);
       frame.add(5);
       g.addFrame(frame);
       frame = new Frame();
       frame.add(5);
       g.addFrame(frame);
       // Check that the total sum is correct
       assertEquals(103, g.getGameSum());
   }
       /** 
    * Test that a game with multiple strikes returns the correct sum
    */
    public void testGameSumWithStrikeAsLastFrame(){
        // US 11
        Game g = new Game();
        Frame frame = new Frame();
 
        // Fill the game with a strike as the last frame and a two bonus throws
        frame.add(8);
        frame.add(2);
        g.addFrame(frame);
        for (int i = 0; i < 8; i++) {
            frame = new Frame();
            frame.add(6);
            frame.add(3);
            g.addFrame(frame);
        }
        frame = new Frame();
        frame.add(10);
        frame.add(0);
        g.addFrame(frame);
        frame = new Frame();
        frame.add(7);
        frame.add(2);
        g.addFrame(frame);
        // Check that the total sum is correct
        assertEquals(107, g.getGameSum());
    }

    /**
     * Test that perfect game works
     */
    public void testPerfectGame() {
        // US 13
        Game g = new Game();
        Frame frame = new Frame();

        for (int i = 0; i < 10; i ++) {
            frame = new Frame();
            frame.add(10);
            frame.add(0);
            g.addFrame(frame);
        }
        // Bonus throw
        frame = new Frame();
        frame.add(10);
        frame.add(10);
        g.addFrame(frame);

        assertEquals(300, g.getGameSum());
    }

    public void testRealGame() {
        // US 14
        Game g = new Game();
        ArrayList<Frame> frames = new ArrayList<Frame>();

        Frame frame1 = new Frame();
        frame1.add(6);
        frame1.add(3);
        frames.add(frame1);

        Frame frame2 = new Frame();
        frame2.add(7);
        frame2.add(1);
        frames.add(frame2);

        Frame frame3 = new Frame();
        frame3.add(8);
        frame3.add(2);
        frames.add(frame3);

        Frame frame4 = new Frame();
        frame4.add(7);
        frame4.add(2);
        frames.add(frame4);

        Frame frame5 = new Frame();
        frame5.add(10);
        frame5.add(0);
        frames.add(frame5);

        Frame frame6 = new Frame();
        frame6.add(6);
        frame6.add(2);
        frames.add(frame6);

        Frame frame7 = new Frame();
        frame7.add(7);
        frame7.add(3);
        frames.add(frame7);

        Frame frame8 = new Frame();
        frame8.add(10);
        frame8.add(0);
        frames.add(frame8);

        Frame frame9 = new Frame();
        frame9.add(8);
        frame9.add(0);
        frames.add(frame9);

        Frame frame10 = new Frame();
        frame10.add(7);
        frame10.add(3);
        frames.add(frame10);

        Frame frame11 = new Frame();
        frame11.add(10);
        frames.add(frame11);

        // Add frames to the game
        for (Frame f : frames) {
            g.addFrame(f);
        }

        assertEquals(135, g.getGameSum());
    }
}
