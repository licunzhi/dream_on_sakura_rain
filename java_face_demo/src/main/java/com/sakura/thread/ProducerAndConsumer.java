package com.sakura.thread;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-16
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        Producer producer = new Producer(queue);
        //Producer producer_copy = new Producer(queue);
        Consumer consumer_first = new Consumer(queue);
        Consumer consumer_copy = new Consumer(queue);

        new Thread(producer).start();
        new Thread(consumer_first).start();
        new Thread(consumer_copy).start();
    }

}

class Producer implements Runnable {

    private final BlockingQueue<String> queue;

    /*构造器进行变量的初始化操作*/
    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (queue.size() >= 100) {
                    System.out.println(Thread.currentThread().getName() + "-生产者暂停生产");
                } else {
                    String producer = UUID.randomUUID().toString();
                    queue.add(producer);
                    System.out.println(Thread.currentThread().getName() + "-生产者-" + producer);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer implements Runnable {

    private final BlockingQueue<String> queue;

    /*构造器进行变量的初始化操作*/
    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                if (!queue.isEmpty()) {
                    String consumer = queue.take();
                    System.out.println(Thread.currentThread().getName() + "-消费了-" + consumer);
                } else {
                    System.out.println(Thread.currentThread().getName() + "-没有消费成功");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
