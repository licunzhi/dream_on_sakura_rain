package com.sakura.plum;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author licunzhi
 * @desc 顺序执行①
 * @date 2018-09-28
 */
@Component
@Order(value = 1)
public class FirstInitAction implements ApplicationRunner {

    //实现接口之后重写其中的run方法
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("-------------application runner start ... 1-------------");
        System.out.println(args.containsOption("sakura"));
        System.out.println(args.getNonOptionArgs());
        System.out.println(Arrays.asList(args.getSourceArgs()));
        System.out.println(args.getOptionNames());
        System.out.println(args.getOptionValues("sakura"));
    }
}
