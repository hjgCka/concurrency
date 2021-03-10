package com.hjg.thread;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/10
 */
public class VolatileMain {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) {
        for(int i=0; i<THREAD_COUNT; i++) {
            new Thread(() -> {
                for(int j=0; j< 1_000; j++) {
                    increase();
                }
            }).start();
        }

        //让给其它线程执行
        Thread.yield();

        //每次结果都不同，且小于20_000
        System.out.println(race);
    }
}
