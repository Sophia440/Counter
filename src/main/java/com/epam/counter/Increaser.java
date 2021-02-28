package com.epam.counter;


import java.util.concurrent.Callable;

public class Increaser implements Callable<Integer> {
    private final Counter counter;
    private int sleepMillis;
    private int runCount;

    public Increaser(Counter counter, int sleepMillis, int runCount) {
        this.counter = counter;
        this.sleepMillis = sleepMillis;
        this.runCount = runCount;

    }

    public Integer call() {
        for (int i = 0; i < this.runCount; i++) {
            counter.increase();
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                System.err.print(e);
            }
        }
        return counter.getCount();
    }
}
