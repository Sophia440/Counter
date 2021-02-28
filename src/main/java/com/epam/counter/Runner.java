package com.epam.counter;

public class Runner {
    private static final int SLEEP_MILLIS = 1;
    private static final int THREADS_COUNT = 10;
    private static final int RUN_COUNT = 100;
    private static final Counter COUNTER = new Counter();

    public static void main(String[] args) {
        System.out.println(COUNTER);
        for (int i = 0; i < THREADS_COUNT; i++) {
            Thread increaser = new Thread(new IncreaserThread(COUNTER, SLEEP_MILLIS, RUN_COUNT));
            increaser.start();
        }
    }
}
