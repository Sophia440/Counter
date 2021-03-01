package com.epam.counter.runner;

import org.junit.Assert;
import org.junit.Test;

public class ExecutorRunnerTest {
    private static final ExecutorRunner RUNNER = new ExecutorRunner();
    private static final int NUMBER_OF_THREADS = 10;
    private static final int RUN_COUNT = 10;
    private static final int EXPECTED = 100;

    @Test
    public void testRunThreadsWithProvidedInputShouldSucceed() {
        int actual = RUNNER.runThreads(NUMBER_OF_THREADS, RUN_COUNT);
        Assert.assertEquals(EXPECTED, actual);
    }
}
