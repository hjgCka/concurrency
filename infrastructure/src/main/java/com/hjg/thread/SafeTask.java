package com.hjg.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/2/13
 */
public class SafeTask implements Runnable {

    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
    }
}
