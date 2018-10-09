package com.sakura;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
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


        //Instance 获取时间
        Instant timestamp = Instant.now();
        /*
        * 之所以是这个时间的原因：DateTimeFormatter进行了格式化
        *   public String toString() {
                return DateTimeFormatter.ISO_INSTANT.format(this);
            }
        * */
        System.out.println("当前时间的时间戳=" + timestamp);// 当前时间的时间戳=2018-09-30T02:28:55.779Z
        /*
        * ChronoUtil支持时间单位：
        *   NANOS
            MICROS
            MILLIS
            SECONDS
            MINUTES
            HOURS
            HALF_DAYS
            DAYS
            WEEKS
            MONTHS
            YEARS
            DECADES
            CENTURIES
            MILLENNIA
            ERAS
            FOREVER
        * */
        Instant hourLater = timestamp.plus(1, ChronoUnit.HOURS);
        System.out.println("一小时之后的时间=" + hourLater);


        long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(),
                        ChronoUnit.SECONDS);
        System.out.println("计算时间戳，精确单位秒级别:" + secondsFromEpoch);
        long MilliSecondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(),
                        ChronoUnit.MILLIS);
        System.out.println("计算时间戳，精确单位毫秒级别:" + MilliSecondsFromEpoch);

        /*

        系统默认时间，获取不同的时间单位

            这里采用的id的格式为：If the zone ID starts with 'UTC+', 'UTC-', 'GMT+', 'GMT-', 'UT+' or 'UT-'
        * */
        LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.of("GMT+8"));
        System.out.printf("%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
                        ldt.getYear(), ldt.getHour(), ldt.getMinute());


        //Temporal Adjuster 时间调节器
        System.out.println("-------------时间调节器-----------------");
        date = LocalDate.of(2000, Month.OCTOBER, 15);
        DayOfWeek dotw = date.getDayOfWeek();
        System.out.printf("%s 是一个星期的 %s%n", date, dotw);

        System.out.printf("月第一天: %s%n",
                        date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.printf("月第一个周一: %s%n",
                        date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.printf("月最后一天: %s%n",
                        date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.printf("下周第一天: %s%n",
                        date.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.printf("明年第一天: %s%n",
                        date.with(TemporalAdjusters.firstDayOfNextYear()));
        System.out.printf("年第一天: %s%n",
                        date.with(TemporalAdjusters.firstDayOfYear()));
        System.out.println("******************************************************");
        LocalDate wanted = LocalDate.now();
        System.out.printf("获取下周一的时间: %s%n",
                        wanted.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));



        // Instant 获取时间
        Instant before = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant = Instant.now();

        System.out.println("消耗时间：" + Duration.between(before, instant).toNanos());
        System.out.println("消耗时间：" + Duration.between(before, instant).toMillis());



        Instant start = Instant.now();
        /*
        *   ofDays
            ofHours
            ofMinutes
            ofSeconds
            ofSeconds
            ofMillis
            ofNanos
        * */
        Duration gap = Duration.ofSeconds(10);
        Instant later = start.plus(gap);
        System.out.println(start + "10秒之后的时间" + later);



        /*计算时间间隔
        *
        * 可以方便取出相隔间隔时间的详细信息
        *   相隔时间的天数
        *   年数
        *   天数等信息
        * */
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);

        Period p = Period.between(birthday, today);
        long p2 = ChronoUnit.DAYS.between(birthday, today);
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                        " months, and " + p.getDays() +
                        " days old. (" + p2 + " days total)");
    }

}
