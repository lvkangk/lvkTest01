package com.lvk.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: kangkang.lv
 * @date: 17-3-15 下午3:50
 */
public class PumpService {
    private static final PumpService instance = new PumpService();
    private static final int MIN_THREADS_NUMBER = 20;
    private static final int MAX_THREADS_NUMBER = 25;
    private static final int MAX_QUEUE_CAPACITY = 42;
    private static ExecutorService executorService;

    private PumpService() {
    }

    public static PumpService getInstance() {
        return instance;
    }

    public void pump(final Command command) {
        executorService.submit(new Runnable() {
            public void run() {
                command.execute();
            }
        });
    }

    static {
        executorService = new ThreadPoolExecutor(20, 25, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(42), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
