package com.multithread.runnabledemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnableLambda {


    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            while (true) {
                int value = count.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " -> " + value);

                if (value >=100) {
                    return;
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count = " + count.get());
    }
}


