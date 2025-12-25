package com.multithread.callabledemo;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> future=executorService.submit(

                new Callable<>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println("This is Callable Example");
                        sleep(1000);
                        return 123;
                    }
                }
        );
        System.out.println("This is Callable Example and main thread is working");
        Integer result = future.get();
        System.out.println("Result from Callable: " + result);
        executorService.shutdown();
    }
}
