package com.sakura.thread;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-08-27
 */
public class ThreadDemo implements Runnable {

    public void run() {
        try {
            Thread.sleep(1000);//等待1秒
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println("重新执行方法");
    }
}
