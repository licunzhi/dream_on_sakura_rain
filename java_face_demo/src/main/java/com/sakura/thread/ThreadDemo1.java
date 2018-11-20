package com.sakura.thread;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-20
 */
public class ThreadDemo1 {

    public static void main(String[] args) {
        MyThread1 one = new MyThread1();
        MyThread1 two = new MyThread1();
        MyThread1 three = new MyThread1();
        /*每个线程的资源都是单独存在的*/
        one.start();
        two.start();
        three.start();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        MyThread2 runnable = new MyThread2();
        Thread runOne = new Thread(runnable);
        Thread runTwo = new Thread(runnable);
        Thread runThree = new Thread(runnable);
        runOne.start();
        runTwo.start();
        runThree.start();
    }


    /*继承Thread类*/
    static class MyThread1 extends Thread {
        private int tickets = 5;

        @Override
        public void run() {

            while (tickets > 0)// 当余票大于0则买票
            {
                System.out.println("卖一张票Thread：剩余ticket=" + --tickets); // 这里--ticket表示卖了一张票后的余票
            }
        }
    }

    static class MyThread2 implements Runnable {

        private int tickets = 5;

        @Override
        public void run() {
            while (tickets > 0)// 当余票大于0则买票
            {
                System.out.println("卖一张票Runnable：剩余ticket=" + --tickets); // 这里--ticket表示卖了一张票后的余票
            }
        }
    }
}
