package com.sakura.rain;

/**
 * @ClassName Main01
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/03 10:37
 */
public class Main01 {
    public static void main(String[] args) {
        /*
         * ThreadPoolExecutor 推荐使用
         *
         * Executors中也是对ThreadPoolExecutor的封装：
         * 不推荐使用，本质上还是对ThreadPoolExecutor的封装
         * 默认使用的队列不安全
         * ---------------------------
         * 无界队列：newFixedThreadPool： new LinkedBlockingQueue<Runnable>())
         * 无界队列：newSingleThreadExecutor:  new LinkedBlockingQueue<Runnable>()
         *----------------------------
         * 阻塞队列，不存储元素： newCachedThreadPool： new SynchronousQueue<Runnable>()
         * ---------------------------
         * ScheduledThreadPoolExecutor: new DelayedWorkQueue()
         *
         * ## 特殊说明：
         * - 任何队列的目的都是为了存储或者是提交执行任务，存储的队列目的是为了和池子进行更好的交互
         * - 如果提交的任务与小于设置的核心线程数，新任务会引发新线程的开辟去执行此次任务，而不是有限存储到队列中
         * - 如果提交的任务数大于核心线程数的限制，优先会放到存储队列中，而不是开辟小于最大核心线程数的新的线程去执行任务
         * - 请求队列持续增长，新任务无法继续排队到队列中，会创建小于最大线程数的新线程执行任务，否则执行拒绝策略
         *
         *
         * There are three general strategies for queuing: 源码中正确的解释为经常用的一般是这三种，没有说绝对是三种
         *
         * 同步队列： Direct handoffs
         * 简单来说就是不会有任何任务被存储起来，提交的任务都会开辟新的线程去执行
         *
         * 无界队列： Unbounded queues
         * 新来的创建的任务可以一直放到存储队列中，虽然不会触发拒绝策略，但是此时定义的最大线程数无效，提交任务的频率持续增长时将导致队列中排队任务无限增长
         *
         * 有界队列：
         * 有界队列结合核心线程数和最大线程数可以实现资源以及执行能力的合理管控，选择合适的拒绝策略或是自定义拒绝策略可以实现执行线程任务的合理处理
         *
         *
         * 下面使用不同的队列方式使用代码展示效果
         * */

    }
}
