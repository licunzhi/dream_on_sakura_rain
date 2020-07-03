package com.sakura.rain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main02
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/03 11:45
 */
public class Main04 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

        try {
            for (int index = 0; index < 15; index++) {
                System.out.println("队列中的任务数量：" + threadPoolExecutor.getQueue().size());
                int finalIndex = index;
                threadPoolExecutor.submit(() -> {
                    Thread.currentThread().setName("线程编码为： " + finalIndex);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            threadPoolExecutor.shutdown();
        }


        /*关闭线程池*/
        threadPoolExecutor.shutdown();

        /*
        设置的线程池的最大线程数依旧满足不了消化队列中的任务，队列中的任务就会一直膨胀
        在业务消化能力和塞入队列能力不匹配的情况下，可能会造成oom

        队列中的任务数量：0
        队列中的任务数量：0
        队列中的任务数量：0
        队列中的任务数量：1
        队列中的任务数量：2
        队列中的任务数量：3
        队列中的任务数量：4
        队列中的任务数量：5
        队列中的任务数量：6
        队列中的任务数量：7
        队列中的任务数量：8
        队列中的任务数量：9
        队列中的任务数量：10
        队列中的任务数量：11
        队列中的任务数量：12
        线程编码为： 0
        线程编码为： 1
        线程编码为： 2
        线程编码为： 3
        线程编码为： 4
        线程编码为： 5
        线程编码为： 6
        线程编码为： 7
        线程编码为： 8
        线程编码为： 9
        线程编码为： 11
        线程编码为： 10
        线程编码为： 12
        线程编码为： 13
        线程编码为： 14
         */

    }
}
