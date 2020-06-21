package com.sakura.rain.demo01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @ClassName CasAba
 * @function [CAS-ABA触发的代码]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/17 11:20
 */
@Slf4j
public class CasAba {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(10, 11);
            atomicInteger.compareAndSet(11, 10);
            log.info("thread 10 -> 11执行, 切换到11");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(10, 12);
            log.info("thread 10 -> 12执行");
        }).start();


        AtomicStampedReference<AtomicInteger> stampedReference = new AtomicStampedReference<>(atomicInteger, 33131);
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("thread 10 -> 11执行, 切换到11");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("thread 10 -> 12执行");
        }).start();

    }
}
