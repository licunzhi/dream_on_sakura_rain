package com.sakura.plum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author licunzhi
 * @desc 顺序执行②
 * @date 2018-09-28
 */
@Component
@Order(value = 2)
public class SecondAction implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("---------------command linner runner 2----------------");
        /*可以获得项目启动参数*/
        Arrays.stream(args).forEach(arg -> System.out.println(arg));
    }
}
