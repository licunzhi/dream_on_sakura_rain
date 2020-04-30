package dream.on.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @ClassName ThreadLocalTest01
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/04/09 08:36
 */
public class ThreadLocalTest04 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private static final int HASH_INCREMENT = 0x61c88647;

    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
        @Override
        public SimpleDateFormat get() {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }

    });

    public static void main(String[] args) {
        /*按照1中的写法会推荐使用线程池进行操作*/
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date = ThreadLocalTest04.date(finalI);
                System.out.println(date);
            });
        }
        threadPool.shutdown();

        /*散列值证明*/
        int n = 5;
        int max = 2 << (n - 1);
        System.out.println(max);
        for (int i = 0; i < max; i++) {
            System.out.print(i * HASH_INCREMENT & (max - 1));
            System.out.print(" ");

        }
    }


    /**
     * 静态时间格式转换方法
     */
    public static String date(int seconds) {
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        System.out.println(simpleDateFormat);
        threadLocal.remove();
        return simpleDateFormat.format(date);
    }
}
