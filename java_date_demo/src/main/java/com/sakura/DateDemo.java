package com.sakura;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * @author licunzhi
 * @desc 时间获取方式
 * @date 2018-08-24
 */
public class DateDemo {

    public static void main(String[] args) {
        /*
         * 获取当前时间，并推算相差指定时间段的新的时间
         * */
        System.out.println("获取当前时间，并推算相差指定时间段的新的时间");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        /*时间的快速计算方式
        * */
        System.out.println(date.minusDays(10));
        System.out.println(date.minusMonths(10));
        System.out.println(date.minusYears(10));
        //本月最后一天前两天
        /**
         * TemporalAdjusters 时间适配方法：
         *        firstDayOfMonth 本月第一天
         *        lastDayOfMonth 本月最后一天
         *        firstDayOfNextMonth 下个月第一天
         *        firstDayOfYear 本年的第一天
         *        lastDayOfYear 本年最后一天
         *    。。。。。。。。。。。。。。还有其他的方法可以参照源码
         */
        LocalDate afterDate = date.with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(afterDate);

        System.out.println("指定参数时间格式");
        LocalDate generateDate = LocalDate.of(2018, Month.JANUARY, 14);
        System.out.println(generateDate);

    }

}
