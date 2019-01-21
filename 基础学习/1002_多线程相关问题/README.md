## 实现多线程的四种方式
    - 继承Thread，重写run()方法
    - 实现Runnable接口，重写run()方法
    - 通过线程池创建
    - Callable和FeatureTask

### Thread and Runnable
- 资源共享
<pre>
    <code>
    class       支持
    Thread       √
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
    
    - 总结
        - 很多博客讲解的是Runnable可以实现资源的共享但是Thread不可以，实际上并不准确。
        上面的代码展示在运行时创建了三个Thread的对象，每个对象都是单独的
        所以自然是每个资源都是唯一的，Runnable的作为后面的Thread的共享同一个自然相当于共享参数
        
        Thread的start()方法连续调用也能实现上面的Runnable的效果
        
        上面的代码对于多线程频繁操作是不安全的，因此真的实现线程操作安全的并发操作还是需要在对共享处理参数的代码块进行枷锁配置（synchronized）
        
        
- 上面展示的是多线程实现的两种方式
    - 继承Thread，重写run()方法
    - 实现Runnable接口，重写run()方法
    <br>还有：
    - 通过线程池创建
    - Callable和FeatureTask

### Callable
```java
public class MyCallableDemo implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallableDemo demo1 = new MyCallableDemo();
        FutureTask<String> stringFutureTask = new FutureTask<>(demo1);
        Thread thread = new Thread(stringFutureTask);
        thread.start();
        String s = stringFutureTask.get();
        System.out.println(s);
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return "这是一个有返回值的线程实现方式";
    }
}
```

### Executor
```java
public class ExecutorDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "这是一个具有灵魂的实现方式";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorDemo demo = new ExecutorDemo();
        Future future = executorService.submit(demo);
        executorService.shutdown();
        System.out.println(future.get().toString());
    }
}
```

### 总结
- 使用Callable的实现方式可以获取线程返回值
- 线程池可以一次执行多个线程，可以获取到线程池中每个线程的执行结果
- 使用Future对象可以对执行方法进行判断，判断是否执行完成
