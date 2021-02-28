package com.epam.counter;

public class Counter {
    private int count = 0;

    public synchronized void increase() {
        this.count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
