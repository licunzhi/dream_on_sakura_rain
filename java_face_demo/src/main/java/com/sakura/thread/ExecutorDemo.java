package com.sakura.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author licunzhi
 * @desc 线程池的实现方式
 * @date 2018-11-24
 */
public class ExecutorDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "这是一个具有灵魂的实现方式";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorDemo demo = new ExecutorDemo();
        Future future = executorService.submit(demo);
        executorService.shutdown();
        System.out.println(future.get().toString());
    }
}
