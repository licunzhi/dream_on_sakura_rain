package com.sakura.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author licunzhi
 * @desc Callable接口实现多线程
 * @date 2018-11-24
 */
public class MyCallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableDemo demo1 = new MyCallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(demo1);
        Thread thread = new Thread(stringFutureTask);
        thread.start();
        String s = stringFutureTask.get();
        System.out.println(s);
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "这是一个有返回值的线程实现方式";
    }
}
