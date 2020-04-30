package dream.on.park;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ThreadLocalTest01
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/04/09 08:36
 */
public class ThreadLocalTest03 {
    public static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static void main(String[] args) {
        /*按照1中的写法会推荐使用线程池进行操作*/
        for (int i = 0; i < 30; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String date;
                synchronized (ThreadLocalTest03.class) {
                     date = ThreadLocalTest03.date(finalI);
                }
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }


    /**
     * 静态时间格式转换方法
     */
    public static String date(int seconds) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date(1000 * seconds);
        return simpleDateFormat.format(date);
    }
}
