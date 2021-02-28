package com.epam.counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Runner {
    private static final int SLEEP_MILLIS = 1;
    private static final int NUMBER_OF_THREADS = 3;
    private static final int RUN_COUNT = 10;
    private static final Counter COUNTER = new Counter();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<Callable<Integer>> threads = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            threads.add(new Increaser(COUNTER, SLEEP_MILLIS, RUN_COUNT));
        }
        List<Future<Integer>> futures = threads.stream()
                .map(thread -> executor.submit(thread))
                .collect(Collectors.toList());
        futures.stream()
                .map(future -> {
                            try {
                                return future.get();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                            return 0;
                        }
                )
                .forEach(System.out::println);

    }
}
