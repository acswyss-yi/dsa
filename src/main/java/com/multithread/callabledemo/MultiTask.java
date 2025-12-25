package com.multithread.callabledemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Callable<String>> list = Arrays.asList(
                () -> "1st Task",
                () -> "2nd Task",
                () -> "3rd Task"
        );
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> result = executorService.invokeAll(list);
        for (Future<String> f : result) {
            System.out.println("Result from Callable: " + f.get());
        }
        executorService.shutdown();
    }
}

