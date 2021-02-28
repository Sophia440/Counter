package com.epam.counter;

public class Increaser implements Runnable {
    private final Counter counter;
    private int sleepMillis;
    private int runCount;

    public Increaser(Counter counter, int sleepMillis, int runCount) {
        this.counter = counter;
        this.sleepMillis = sleepMillis;
        this.runCount = runCount;
    }

    public void run() {
        synchronized (counter) {
            for (int i = 0; i < this.runCount; i++) {
                counter.increase();
                System.out.println(counter);
                try {
                    Thread.sleep(sleepMillis);
                } catch (InterruptedException e) {
                    System.err.print(e);
                }
            }
        }
    }
}
