package com.multithread.callabledemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.Thread.sleep;

public class CallableWithLambda {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(() -> {
            sleep(1000);
            System.out.println("This is Callable Example with Lambda");
            return "Hello from Callable with Lambda";
        });
        System.out.println("Main thread is working while Callable is executing");
        String result = future.get();
        System.out.println("Result from Callable with Lambda: " + result);
        executorService.shutdown();
    }
}
