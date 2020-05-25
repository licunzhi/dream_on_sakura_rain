package com.sakura.demo;

import com.sun.deploy.util.StringUtils;

import java.io.Console;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName HashMapTest
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/05/21 13:46
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> result = new HashMap<>(64);

        /*达到扩容临界值*/
        result.put(65, 1);
        result.put(129, 3);
        /*拿到红黑树的点*/
        result.put(193, 3);
        result.put(257, 3);
        result.put(321, 3);
        result.put(385, 3);
        result.put(449, 3);
        result.put(513, 3);
        result.put(577, 3);


        result.put(2, 2);
        result.put(3, 3);

        result.put(4, 4);

        for (int index = 5; index < 100; index++) {
            result.put(String.valueOf(index), 4);
        }


        System.out.println(result.size());

        /*Executors.newFixedThreadPool(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 10, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));
        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.execute(new DemoTask(2));
        }*/
    }


}

class DemoTask implements Runnable {

    private int taskNum;

    public DemoTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
