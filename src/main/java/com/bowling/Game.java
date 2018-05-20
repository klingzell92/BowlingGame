package com.bowling;

import java.util.ArrayList;

class Game 
{
    public ArrayList<Frame> gameFrames = new ArrayList<Frame>();

    public void addFrame(Frame f) {
        gameFrames.add(f);
    }

    public int getGameSum() {
        int sum = 0;
        int iteration = 0;
        
        for (Frame f : this.gameFrames) {
            int frameSum = f.sum;
            int ball1 = (Integer) f.get(0);

            // Check if the first throw is a strike
            if(ball1 == 10 & iteration < 9 ) {
                // Add sum of the next frame to this frames sum
                frameSum += gameFrames.get(iteration + 1).sum;

                // If the next frame is a strike add score of the first thorw of the frame after
                int nextFrameBall1 = (Integer) gameFrames.get(iteration + 1).get(0);
                if(nextFrameBall1 == 10) {
                    frameSum += (Integer) gameFrames.get(iteration + 2).get(0);
                }
            } 

            // Check that the first throw is not a strike but the sum of the frame is 10 wich indicates that it is a spare
            if (ball1 != 10 & frameSum == 10 & iteration < 9 ) {
                // Add score of the first throw of the next frame to this frames sum
                frameSum += (Integer) gameFrames.get(iteration + 1).get(0);
            }
            sum += frameSum;
            iteration++;
        }
        return sum;
    }
}
