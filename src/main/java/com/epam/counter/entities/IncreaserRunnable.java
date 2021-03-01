package com.epam.counter.entities;

import java.util.stream.IntStream;

public class IncreaserRunnable implements Runnable {
    private final Counter counter;
    private int runCount;

    public IncreaserRunnable(Counter counter, int runCount) {
        this.counter = counter;
        this.runCount = runCount;
    }

    public void run() {
        IntStream.range(0, this.runCount).forEach(number -> counter.increase());
    }

    @Override
    public String toString() {
        return counter.toString() + ", number of increments (runs) = " + this.runCount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        IncreaserRunnable increaserObject = (IncreaserRunnable) object;
        return runCount == increaserObject.runCount && counter.equals(increaserObject.counter);
    }

    @Override
    public int hashCode() {
        return counter.hashCode() + Integer.hashCode(runCount);
    }
}
