package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main02
 * @function [提交任务数量 > 最大线程数 + 排队队列]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/21 20:47
 */
public class Main02 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        /*在没有调用预备创建线程核心数之前，打印线程池中的线程个数*/
        System.out.println(threadPool.getQueue());

        for (int index = 0; index < 20; index++) {
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

        System.out.println("线程池中的队列数量" + threadPool.getQueue().size());
        System.out.println("线程池中活跃的线程数" + threadPool.getActiveCount());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("线程池中的队列数量" + threadPool.getQueue().size());
        System.out.println("线程池中活跃的线程数" + threadPool.getActiveCount());
        System.out.println("线是否处于活跃的状态" + threadPool.getActiveCount());

        threadPool.shutdownNow();
        /*
            Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@7a5d012c rejected from java.util.concurrent.ThreadPoolExecutor@79698539[Running, pool size = 5, active threads = 5, queued tasks = 10, completed tasks = 0]
            at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
            at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
            at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
            at java.util.concurrent.AbstractExecutorService.submit(AbstractExecutorService.java:112)
            at com.sakura.rain.Main02.main(Main02.java:23)
            线程编码为： 14
            线程编码为： 0
            线程编码为： 13
            线程编码为： 12
            线程编码为： 1
            线程编码为： 2
            线程编码为： 4
            线程编码为： 6
            线程编码为： 3
            线程编码为： 5
            线程编码为： 7
            线程编码为： 8
            线程编码为： 9
            线程编码为： 10
            线程编码为： 11

           上面的运行结果可以看出，已经提交到线程池中任务还在继续执行直到结束，但是后续超过15的线程全部执行失败了，并且在程序中抛出了异常
           我们在最后还有几行打印的输出也没有执行，说明程序异常抛出之后影响到了后面的代码的执行。

           这种用上了最大启用线程数加上队列总和都没有办法承载的出现的异常处理的方式叫做线程的拒绝策略,在ThreadPoolExecutor中有四个内部实现类：
            AbortPolicy
            DiscardPolicy
            DiscardOldestPolicy
            CallerRunsPolicy
           接下来的MainDemo中演示这四种拒绝策略的区别

        */
    }
}
