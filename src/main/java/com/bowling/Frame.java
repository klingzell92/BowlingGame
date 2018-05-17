package com.bowling;

import java.util.ArrayList;

class Frame extends ArrayList
{
    int maxSize = 2;
    public int sum;

    public boolean add(int value) {
        if (this.size() >= this.maxSize) {
            return false;
        }

        if (this.sum + value  > 10) {
            return false;
        }
        
        this.sum += value;
        super.add(value);
        return true;
    }

    public int sum() {
        return this.sum;
    }
}
