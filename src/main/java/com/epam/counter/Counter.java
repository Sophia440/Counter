package com.epam.counter;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void increase() {
        this.count++;
    }

    public int getCount() {
        return count;
    }
}
