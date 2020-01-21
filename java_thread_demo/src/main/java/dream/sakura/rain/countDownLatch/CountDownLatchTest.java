package dream.sakura.rain.countDownLatch;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName CountDownLatchTest
 * @Description 解释
 * @Author lcz
 * @Date 2020/01/21 09:17
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Player(begin, end));
            thread.start();
        }

        try {
            System.out.println("the race begin");
            begin.countDown();
            end.await();
            System.out.println("the race end");
        } catch (Exception e) {
            e.printStackTrace();
        }

        CountDownLatch processTest = new CountDownLatch(10);
        for (int i = 0; i < 7; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                processTest.countDown();
                System.out.println(processTest.getCount());
            }
        }
        System.out.println("等待执行操作结束");
        try {
            System.out.println(LocalDateTime.now());
            /*等待一定的时间之后，仍然没有消费完，直接终止*/
            System.out.println(processTest.getCount());
            processTest.await(3, TimeUnit.SECONDS);
            System.out.println(LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


/**
 * 选手
 */
class Player implements Runnable {

    private CountDownLatch begin;

    private CountDownLatch end;

    Player(CountDownLatch begin, CountDownLatch end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {

        try {
            /*等待作用，阻塞线程执行*/
            begin.await();
            System.out.println(Thread.currentThread().getName() + " arrived !");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
