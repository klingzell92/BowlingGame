package com.bowling;

import java.util.ArrayList;

import com.bowling.exceptions.FrameEndException;

class Frame
{
    ArrayList<Integer> tries = new ArrayList<Integer>();

    public Frame() {
        
    }

    public void addResult(int score) {
        this.tries.add(score);
    }
}
