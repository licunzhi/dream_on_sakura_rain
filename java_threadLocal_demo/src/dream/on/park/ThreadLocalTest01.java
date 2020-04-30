package dream.on.park;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ThreadLocalTest01
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/04/09 08:36
 */
public class ThreadLocalTest01 {
    public static void main(String[] args) {
        new Thread(() -> {
            String date = ThreadLocalTest01.date(10);
            System.out.println(date);
        }).start();

        new Thread(() -> {
            String date = ThreadLocalTest01.date(104707);
            System.out.println(date);
        }).start();
    }


    /**
     * 静态时间格式转换方法
     */
    public static String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }
}
