package com.sakura.rain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main02
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/03 11:45
 */
public class Main03 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

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
        有界队列配合拒绝策略可以保证待执行的任务在系统可控范围内，
        所以当超出队列存储能力范围之后选择合适的拒绝策略，可以使得队列处于充盈的状态

        队列中的任务数量：0
        队列中的任务数量：0
        队列中的任务数量：0
        队列中的任务数量：1
        队列中的任务数量：2
        队列中的任务数量：3
        队列中的任务数量：4
        队列中的任务数量：5
        队列中的任务数量：5
        队列中的任务数量：5
        队列中的任务数量：5
        线程编码为： 0
        线程编码为： 1
        线程编码为： 8
        线程编码为： 9
        线程编码为： 7
        线程编码为： 3
        线程编码为： 2
        线程编码为： 4
        线程编码为： 5
        线程编码为： 6
         */

    }
}
