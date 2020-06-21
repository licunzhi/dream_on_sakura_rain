package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main
 * @function [提交任务数量小于  核心+队列]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/21 19:39
 */
public class Main00 {
    public static void main(String[] args) {

        /*
          int corePoolSize： 核心线程数，开始创建的时候线程池中并没有任何线程，而是在任务到来的时候开始创建线程
           也可以预创建线程：prestartAllCoreThreads(源码解释：覆盖默认当任务开始执行创建的方式，预先创建好核心线程数)
           当线程池中的任务达到核心线程数的时候，后面的任务就会排队在任务中
           如果超出了最大排队的数量，这个时候默认会拒绝后面的任务报错提示，这种称之为拒绝策略，拒绝策略就是这段代码需要演示的关键点
          int maximumPoolSize, 最大支持创建的线程数量
          long keepAliveTime, 线程保持活跃的时间，线程池中线程没有进行中的任务空闲过长时间会被回收
          TimeUnit unit, 设置活跃时间的单位
          LinkedBlockingDeque<Runnable> workQueue, 一个基于链表结构的阻塞队列
          ThreadFactory threadFactory, 线程工厂，可以设置创建出的线程名字更加具有辨识度和意义
          RejectedExecutionHandler handler 线程满了之后的拒绝策略，常见的有四种-默认策略是：AbortPolicy
            这里面既然牵涉到了拒绝策略，那么就要列举一下常见的拒绝策略了。经常用到的四种拒绝策略都是
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread.currentThread().setName("demo--" + System.currentTimeMillis());
                System.out.println(Thread.currentThread().getName());
                return null;
            }
        }, new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.shutdown();



        /*
        * 下面这段代码展示的是当排队中的任务数量超出核心线程数
        * 核心线程数：2
        * 最大支持创建线程的数量为： 5
        * 保持活跃的时间 3s
        * 队列使用的是阻塞链表 LinkedBlockingDeque
        * */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10), new ThreadPoolExecutor.AbortPolicy());

        /*在没有调用预备创建线程核心数之前，打印线程池中的线程个数*/
        System.out.println(threadPool.getQueue());

        for (int index = 0; index < 10; index++) {
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
        打印的结果为：
            []
            线程池中的队列数量8
            线程池中活跃的线程数2
            线程编码为： 1
            线程编码为： 0
            线程编码为： 3
            线程编码为： 2
            线程编码为： 4
            线程编码为： 5
            线程编码为： 6
            线程编码为： 7
            线程编码为： 8
            线程编码为： 9

            线程池中的队列数量0
            线程池中活跃的线程数0
            线是否处于活跃的状态0

            在代码中一共创建了 10 个线程，但是总共调用了两个线程去执行，为什么不是五个：
                核心线程： 10 > 2
                队列：    10 = 10
                任务进来之后有两个线程放到核心线程中进行执行，那么队列中还有8个，默认排列到线程中继续等待，知道前面的线程执行结束之后在拿出队列中的线程进行执行
        * */
    }
}
