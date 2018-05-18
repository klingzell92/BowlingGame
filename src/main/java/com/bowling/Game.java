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

        for (Frame f : this.gameFrames) {
            sum += f.sum;
        }

        return sum;
    }
}
