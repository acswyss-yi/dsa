package com.multithread.threaddemo;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreadAtomic extends Thread {
    private static AtomicInteger count = new AtomicInteger(0);
    @Override
    public void run() {
        while (true) {
            count.addAndGet(1);
            System.out.println(Thread.currentThread().getName() + " -> " + count);
            if(count.get()>=100){
                return;
            }
        }
    }
}
