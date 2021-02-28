package com.epam.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Runner {
    private static final int NUMBER_OF_THREADS = 10;
    private static final int RUN_COUNT = 10;
    private static final Counter COUNTER = new Counter();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Future<?>> futures = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            Runnable runnable = new IncreaserRunnable(COUNTER, RUN_COUNT);
            Future<?> future = executor.submit(runnable);
            futures.add(future);
        }

        for (Future<?> future : futures) {
            future.get();
        }

        System.out.println("Counter = " + COUNTER.getCount());

        executor.shutdown();
    }
}
