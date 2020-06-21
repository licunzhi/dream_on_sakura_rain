package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName 任务数量大于队列核心之和
 * @function [提交任务数 > 核心+队列]
 * @notice 默认拒绝策略
 * @Author lcz
 * @Date 2020/06/21 20:30
 */
public class Main01 {
    public static void main(String[] args) {
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
            System.out.println("当任务提交index坐标为" + index + "时，活跃的线程数为：" + threadPool.getActiveCount());
        }

        System.out.println("线程池中的队列数量" + threadPool.getQueue().size());
        System.out.println("线程池中活跃的线程数" + threadPool.getActiveCount());

        /*为了窥探线程数量减少的过程，执行这段循环代码*/
        int activeCount = threadPool.getActiveCount();
        long currentTimeMillis = System.currentTimeMillis();
        while (threadPool.getActiveCount() != 0) {
            if (activeCount != threadPool.getActiveCount()) {
                long timeMillis = System.currentTimeMillis();
                System.out.println("减少时间间隔: " + (timeMillis - currentTimeMillis));
                activeCount = threadPool.getActiveCount();
                System.out.println("线程活跃数减少： " + threadPool.getActiveCount());
            }
        }


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
            []
            当任务提交index坐标为0时，活跃的线程数为：1
            当任务提交index坐标为1时，活跃的线程数为：2
            当任务提交index坐标为2时，活跃的线程数为：2
            当任务提交index坐标为3时，活跃的线程数为：2
            当任务提交index坐标为4时，活跃的线程数为：2
            当任务提交index坐标为5时，活跃的线程数为：2
            当任务提交index坐标为6时，活跃的线程数为：2
            当任务提交index坐标为7时，活跃的线程数为：2
            当任务提交index坐标为8时，活跃的线程数为：2
            当任务提交index坐标为9时，活跃的线程数为：2
            当任务提交index坐标为10时，活跃的线程数为：2
            当任务提交index坐标为11时，活跃的线程数为：2
            当任务提交index坐标为12时，活跃的线程数为：3
            当任务提交index坐标为13时，活跃的线程数为：4
            当任务提交index坐标为14时，活跃的线程数为：5
            线程池中的队列数量10
            线程池中活跃的线程数5
            线程编码为： 0
            线程编码为： 1
            线程编码为： 12
            线程编码为： 14
            线程编码为： 13
            线程编码为： 3
            线程编码为： 2
            线程编码为： 5
            线程编码为： 6
            线程编码为： 4
            线程编码为： 8
            线程编码为： 7
            线程编码为： 11
            线程编码为： 9
            线程编码为： 10

            线程池中的队列数量0
            线程池中活跃的线程数0
            线是否处于活跃的状态0

            在代码中一共创建了 15 个线程，但是总共调用了5个线程去执行，为什么这个时候是五个：
                最开始调用核心线程数去执行，2个，队列中的任务持续进行增长
                创建12个任务时，在下一个任务进来是发现队列中承载的能力已经达到了最大的限度，于是便开始扩充可以执行任务的线程数
                从上面的打印结果证明这个结论是再形象不过了
        * */
    }
}
