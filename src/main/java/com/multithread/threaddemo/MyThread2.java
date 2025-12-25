package com.multithread.threaddemo;

public class MyThread2 extends Thread {
    private static int a = 0;
    @Override
    public void run() {
        while (a <= 100) {
            synchronized (this) {
                a++;
                System.out.println("Now the value is:" + a);
            }

        }
    }

    public void run1() {
        int a = 0;
        while (a <= 100) {
            a++;
            System.out.println("Now the value is:" + a);
        }

    }
}


