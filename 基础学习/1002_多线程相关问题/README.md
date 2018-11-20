### Thread and Runnable
- 资源共享
<pre>
    <code>
    class       支持
    Thread       ×
    Runnable     √ 
    </code>
</pre>
DEMO讲解
```java
public class ThreadDemo1 {

    public static void main(String[] args) {
        MyThread1 one = new MyThread1();
        MyThread1 two = new MyThread1();
        MyThread1 three = new MyThread1();
        /*每个线程的资源都是单独存在的*/
        /*one.start();
        two.start();
        three.start();*/
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
        private int tickets = 10;

        @Override
        public void run() {

            while (tickets > 0)// 当余票大于0则买票
            {
                System.out.println("卖一张票：剩余ticket=" + --tickets); // 这里--ticket表示卖了一张票后的余票
            }
        }
    }

    static class MyThread2 implements Runnable {

        private int tickets = 100;

        @Override
        public void run() {
            while (tickets > 0)// 当余票大于0则买票
            {
                System.out.println("卖一张票：剩余ticket=" + --tickets); // 这里--ticket表示卖了一张票后的余票
            }
        }
    }
}
```
DEMO运行结果
```shell
    卖一张票Thread：剩余ticket=4
    卖一张票Thread：剩余ticket=4
    卖一张票Thread：剩余ticket=3
    卖一张票Thread：剩余ticket=3
    卖一张票Thread：剩余ticket=2
    卖一张票Thread：剩余ticket=2
    卖一张票Thread：剩余ticket=1
    卖一张票Thread：剩余ticket=1
    卖一张票Thread：剩余ticket=0
    卖一张票Thread：剩余ticket=0
    卖一张票Thread：剩余ticket=4
    卖一张票Thread：剩余ticket=3
    卖一张票Thread：剩余ticket=2
    卖一张票Thread：剩余ticket=1
    卖一张票Thread：剩余ticket=0
    卖一张票Runnable：剩余ticket=4
    卖一张票Runnable：剩余ticket=3
    卖一张票Runnable：剩余ticket=2
    卖一张票Runnable：剩余ticket=1
    卖一张票Runnable：剩余ticket=0
```

- 资源共享总结
    - 优点
        - 适合多个线程处理一个资源
        - 避免单继承带带来的限制
        - 代码复用性，数据处理分离，处理逻辑可以被共享
    
    - 为什么可以资源共享
