package com.sakura.rain;

/**
 * @ClassName Main001
 * @function [为什么会需要守护线程]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/24 23:06
 */
public class Main001 {
    public static void main(String[] args) {

        /*代码段*/
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        Thread thread = new Thread(() -> {
            for (;;) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------");

            }
        });
        thread.setDaemon(true);
        thread.start();

        /*
        程序执行结果：
        1592879626664
        1592879627664
        1592879628665
        1592879629666
        1592879630666
        1592879631666
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        1592879632666
        1592879633667
        1592879634667
        1592879635667
        1592879636667
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        1592879637668
        1592879638668
        1592879639669
        1592879640670
        1592879641670
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        1592879642670
        1592879643671
        1592879644672
        1592879645672
        1592879646672
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        1592879647672
        1592879648672
        1592879649673
        1592879650673
        1592879651673
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        1592879652674
        1592879653674
        1592879654675
        1592879655675
        1592879656675
        ------这个线程时不时会打印一些信息[比如定时查看系统内存，执行gc动作等]------
        * */


        /*
        * 总结说明：
        * 系统在正常运行状态的时候执行一些列业务操作或是其他的内容。
        *
        * 辅助需要一个线程执行某些额外的动作，此线程存活的依据或者是执行动作的条件是系统中还有其他线程正在执行
        * 要求在系统中其他任务结束之后此线程便不再运行，人为管理这种进程并不合理。
        *
        * 因此设置守护线程，当其他线程结束之后，此线程便随之结束
        * */
    }
}


class ThreadDemo extends Thread {
    @Override
    public void run() {
        int count = 0;
        while (count <= 30) {
            count = count + 1;
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}