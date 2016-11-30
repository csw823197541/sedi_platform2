package com.sedi.process;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by csw on 2016/11/29 16:35.
 * Explain:
 */
public class MSThreadPool {

    public static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public static ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(20);

    public static ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

}
