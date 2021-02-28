package com.epam.counter;

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
}
