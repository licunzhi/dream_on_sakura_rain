package com.sakura.rain;

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
public class Main02 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue<>());

        try {
            for (int index = 0; index < 10; index++) {
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
        打印结果显示，队列中不做任务任务的存储，所以队列中全部都是0
        这里面为了测试每个线程都是新创建的，在这个设置了最大线程数为最大值
        实际中要根据实际情况进行设置
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            队列中的任务数量：0
            线程编码为： 2
            线程编码为： 0
            线程编码为： 5
            线程编码为： 3
            线程编码为： 6
            线程编码为： 4
            线程编码为： 1
            线程编码为： 9
            线程编码为： 8
            线程编码为： 7
        *
        *
        * */
    }
}
