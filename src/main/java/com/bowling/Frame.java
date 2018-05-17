package com.bowling;

import java.util.ArrayList;

class Frame<E> extends ArrayList<E>
{
    int maxSize = 2;

    // public Frame() {
    //     this.maxSize = maxSize;
    // }

    @Override
    public boolean add(E value) {
        if (this.size() >= this.maxSize) {
            return false;
        }

        super.add(value);
        return true;
    }
}
