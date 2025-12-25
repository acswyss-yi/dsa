package com.multithread.threaddemo;

public class StartPoint {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread1 = new TwoThreadAtomic ();
        Thread myThread2 = new TwoThreadAtomic ();
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
    }
}
