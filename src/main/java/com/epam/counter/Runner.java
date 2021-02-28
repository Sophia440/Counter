package com.epam.counter;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final int SLEEP_MILLIS = 1;
    private static final int THREADS_COUNT = 10;
    private static final int RUN_COUNT = 10;
    private static final Counter COUNTER = new Counter();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        System.out.println(COUNTER);
        for (int i = 0; i < THREADS_COUNT; i++) {
            Increaser increaser = new Increaser(COUNTER, SLEEP_MILLIS, RUN_COUNT);
            Thread thread = new Thread(increaser);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
