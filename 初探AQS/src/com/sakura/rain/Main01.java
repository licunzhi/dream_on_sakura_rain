package com.sakura.rain;

import java.util.ArrayList;

/**
 * @ClassName Main01
 * @function [不加锁，多线程操作数据]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/23 19:12
 */
public class Main01 {

    private static int m = 0;

    public static void main(String[] args) {

        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    m++;
                }
            }));
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(m);
    }

    /*
    * 多个线程操作一个对象，造成计算结果不准确是典型的线程不安全问题
    * */
}
