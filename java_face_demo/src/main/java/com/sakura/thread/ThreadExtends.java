package com.sakura.thread;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-27
 */
public class ThreadExtends extends Thread {

    private String name = "dream on sakura rain";

    public void run() {
        try {
            Thread.sleep(1000);//等待1秒
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println(name);
    }
}
