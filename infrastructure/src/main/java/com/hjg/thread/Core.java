package com.hjg.thread;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/2/13
 */
public class Core {

    public static void main(String[] args) {
        UnSafeTask task = new UnSafeTask();
        print(task);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        SafeTask safeTask = new SafeTask();
        print(safeTask);
    }

    private static void print(Runnable runnable) {
        for(int i=0; i<5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
