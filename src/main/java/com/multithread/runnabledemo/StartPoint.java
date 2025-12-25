package com.multithread.runnabledemo;

public class StartPoint {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable1());
        Thread t2 = new Thread(new MyRunnable1());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
