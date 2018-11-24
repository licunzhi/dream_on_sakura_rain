package com.sakura.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-24
 */
public class ExecutorDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "只是一个具有灵魂的实现方式";
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorDemo demo = new ExecutorDemo();
        FutureTask<String> task = new FutureTask<>(demo);
    }
}
