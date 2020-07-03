package com.sakura.rain;

import java.util.ArrayList;

/**
 * @ClassName Main02
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/23 19:16
 */
public class Main02 {
    private static int m = 0;

    public static void main(String[] args) {

        ArrayList<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threadList.add(new Thread(() -> {
                synchronized (Main02.class) {
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
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
}
