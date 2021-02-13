package com.hjg.thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/2/13
 */
public class UnSafeTask implements Runnable {

    //这个变量被每一个线程所共享
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("starting Thread: %s : %s\n", Thread.currentThread().getId(), startDate);

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里打印的值，可能会是一样的。因为被其它线程初始化了
        System.out.printf("Thread finished: %s : %s\n", Thread.currentThread().getId(), startDate);
    }
}
