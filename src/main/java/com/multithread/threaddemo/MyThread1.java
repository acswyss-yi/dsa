package com.multithread.threaddemo;

public class MyThread1 extends Thread {
    private static int count = 0;
    private static final Object lock = new Object();
    private static boolean stop = false;

    @Override
    public void run() {
        while (true) {
            //synchronized (this) {
            synchronized (lock) {
                if (count > 100) {
                    stop = true;
                    return;
                }
                count++;
                System.out.println(Thread.currentThread().getName() + " -> " + count);
            }

            if (stop) return;
        }
    }

}
