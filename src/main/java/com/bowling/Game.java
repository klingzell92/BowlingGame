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

            if(ball1 == 10 & iteration < 9 ) {
                frameSum += gameFrames.get(iteration + 1).sum;
            }
            sum += frameSum;
            iteration++;
        }
        System.out.print(sum);
        return sum;
    }
}
