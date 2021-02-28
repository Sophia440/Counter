package com.epam.counter;

public class Counter {
    private int counter;

    public Counter() {
        this.counter = 0;
    }

    public void increase() {
        this.counter++;
    }

    @Override
    public String toString() {
        return "counter = " + this.counter;
    }
}
