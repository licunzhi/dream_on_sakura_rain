package com.sakura.rain;

/**
 * @ClassName Main01
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/23 11:18
 */
public class Main01 {
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int countSync = Utils.getCountSync();
            System.out.println(countSync);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int countSync = Utils.getCount();
            System.out.println(countSync);
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int countSyncClass = Utils.getCountClass();
            System.out.println(countSyncClass);
        }).start();
    }
}

class Utils {
    static synchronized int getCountSync(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1228;
    }

    public static int getCount() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1227;
    }

    public static int getCountClass() {
        synchronized (Utils.class) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1226;
        }
    }
}