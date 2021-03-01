package com.epam.counter.runner;

import com.epam.counter.entities.Counter;
import com.epam.counter.entities.IncreaserRunnable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorRunner implements Runner {
    private static final Counter COUNTER = new Counter();
    private static final Logger LOGGER = LogManager.getLogger(ExecutorRunner.class);

    @Override
    public int runThreads(int numberOfThreads, int runCount) {
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Runnable runnable = new IncreaserRunnable(COUNTER, runCount);
            Future<?> future = executor.submit(runnable);
            futures.add(future);
        }
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        executor.shutdown();
        return COUNTER.getCount();
    }
}
