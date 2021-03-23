package com.hjg.thread;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/3/23
 */
public class Volatile2Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // 开启线程
        myThread.start();

        // 主线程执行
        for (; ; ) {
            //没有每次都从主内存进行检查，从主内存复制过来之后，一直没更新

            //for循环内加上synchronized之后可以打印，因为每次获得锁都会清空工作内存
            synchronized (myThread) {
                if (myThread.isFlag()) {
                    System.out.println("主线程访问到 flag 变量");
                    break;
                }
            }
        }
    }
}

class MyThread extends Thread {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 修改变量值
        flag = true;
        System.out.println("flag = " + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
