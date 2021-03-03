package com.epam.counter.runner;

import com.epam.counter.entities.Counter;
import com.epam.counter.entities.IncreaserRunnable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ThreadRunner implements Runner {
    private static final Counter COUNTER = new Counter();
    private static final Logger LOGGER = LogManager.getLogger(ThreadRunner.class);

    @Override
    public int runThreads(int numberOfThreads, int runCount) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            IncreaserRunnable increaser = new IncreaserRunnable(COUNTER, runCount);
            Thread thread = new Thread(increaser);
            thread.start();
            threads.add(thread);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return COUNTER.getCount();
    }
}


