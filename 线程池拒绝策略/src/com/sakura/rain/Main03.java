package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main03
 * @function [提交的任务数量大于最大线程数加上队列]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/21 21:01
 */
public class Main03 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.AbortPolicy());

        /*在没有调用预备创建线程核心数之前，打印线程池中的线程个数*/
        System.out.println("调用创建核心线程初始化方法之前： " + threadPool.getActiveCount());
        /*再调用预备创建核心线程数之后，打印线程池中线程的个数*/
        threadPool.prestartAllCoreThreads();
        System.out.println("调用创建核心线程初始化方法之后：" + threadPool.getActiveCount());


        /*休眠时间大于设置的默认活跃时间*/
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("休眠时间大于默认的活跃时间之后：" + threadPool.getActiveCount());



        for (int index = 0; index < 15; index++) {
            int finalIndex = index;
            threadPool.submit(() -> {
                Thread.currentThread().setName("线程编码为： " + finalIndex);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
        }
        threadPool.shutdown();
        /*
        *
        *   调用创建核心线程初始化方法之前： 0
            调用创建核心线程初始化方法之后：1
            Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@6cd8737 rejected from java.util.concurrent.ThreadPoolExecutor@13969fbe[Running, pool size = 2, active threads = 2, queued tasks = 2, completed tasks = 0]
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
            at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
            at com.sakura.rain.Main03.main(Main03.java:26)
            线程编码为： 0
            线程编码为： 2
            线程编码为： 1
            线程编码为： 3

            在进行对拒绝策略说明之前，这里先说明两个方法：prestartCoreThread() and prestartAllCoreThreads()
            默认创建的线程池中是没有执行的线程的，调用这个方法之后，会创建出默认核心数量的活跃线程

            代码在创建线程池的时候执行了线程池的拒绝策略：AbortPolicy()
            这种策略就是在上述任务数大于最大线程+队列容量情况时，对后续提交的任务进行拒绝策略，但是这种失败的拒绝提示会抛出异常。
            出现异常的目的是为了能够及时发现问题，或者是针对问题的任务进行特殊处理或者是操作。

            拒绝策略是实现了接口：RejectedExecutionHandler
            重写了其中的：rejectedExecution()方法
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            }

        * */

    }
}
