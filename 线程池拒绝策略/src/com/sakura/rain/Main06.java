package com.sakura.rain;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Main06
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/21 21:27
 */
public class Main06 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.CallerRunsPolicy());


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
        * 代码执行的结果：
            线程编码为： 0
            线程编码为： 3
            线程编码为： 4
            线程编码为： 6
            线程编码为： 2
            线程编码为： 1
            线程编码为： 8
            线程编码为： 7
            线程编码为： 5
            线程编码为： 9
            线程编码为： 11
            线程编码为： 10
            线程编码为： 13
            线程编码为： 12
            线程编码为： 14
        *
        文档中解释为：只要线程在则会等待直到所有的方法都执行

        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                r.run();
            }
        }
        * */


        /*因此我在下面这段代码中使用方法强制关闭，演示在线程池关闭之后，后续的方法不再执行*/
        ThreadPoolExecutor threadPoolClose = new ThreadPoolExecutor(1, 2, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2), new ThreadPoolExecutor.CallerRunsPolicy());


        for (int index = 0; index < 15; index++) {
            int finalIndex = index;
            threadPoolClose.submit(() -> {
                Thread.currentThread().setName("线程编码为： " + finalIndex);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });
            if (index == 10) {
                threadPoolClose.shutdownNow();
                System.out.println("线程池现在的状态为：");
                System.out.println(threadPoolClose.isShutdown());
            }
        }

        /*
        *   线程编码为： 4
            线程编码为： 0
            线程编码为： 3
            线程编码为： 2
            线程编码为： 5
            线程编码为： 1
            Disconnected from the target VM, address: '127.0.0.1:50705', transport: 'socket'
            java.lang.InterruptedException: sleep interrupted
            at java.lang.Thread.sleep(Native Method)
            at com.sakura.rain.Main06.lambda$main$0(Main06.java:70)
            at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
            at java.util.concurrent.FutureTask.run$$$capture(FutureTask.java:266)
            at java.util.concurrent.FutureTask.run(FutureTask.java)
            at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
            at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
            at java.lang.Thread.run(Thread.java:745)
            线程编码为： 9
            线程编码为： 6
            线程编码为： 7
            线程池现在的状态为：
            true
            线程编码为： 8

            执行结果看得出这个玩意真的不再执行了
            */
    }
}
