package com.bowling;

import java.util.ArrayList;

class Game 
{
    public ArrayList<Frame> gameFrames = new ArrayList<Frame>();

    public void addFrame(Frame f) {
        gameFrames.add(f);
    }
}
