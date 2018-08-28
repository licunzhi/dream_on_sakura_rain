package com.sakura.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author licunzhi
 * @desc 线程相关
 * @date 2018-08-27
 */
public class ThreadMain {

    @Test
    public void testThread() {
        /*
         * ①线程实现的两种方式
         *   Thread 继承类
         *   Runnable 实现接口
         * */
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();
        ThreadExtends threadExtends = new ThreadExtends();
        threadExtends.start();
    }

    /*
     * ②数据同步问题
     *   允许使用多线程操作数据资源，多个操作同一个资源时保持数据的一致有效性
     *
     *   可以使用synchronized方法
     *   可以使用synchronized方法同步代码块
     *   volatile 特殊变量实现，但是没有办法对原子操作
     *   ReentrantLock类是可重入、互斥、实现了Lock接口的锁， 它与使用synchronized方法和快具有相同的基本行为和语义，并且扩展了其能力
     * */
    public synchronized void testSynchronizeMethod() {
        System.out.println("同步方法");
    }

    public void testSynchronizeBlock() {
        synchronized (this) {
            System.out.println("操作数据的代码块");
        }
        System.out.println("非操作数据部分");
    }


    @Test
    public void testReenreantLock() {
        ReentrantLock lock = new ReentrantLock();
        /*
         * 常用方法
         * lock获得锁
         * unlock解锁
         * */
        lock.lock();
        System.out.println(lock.isLocked());
        lock.unlock();
        System.out.println(lock.isLocked());
    }
}
