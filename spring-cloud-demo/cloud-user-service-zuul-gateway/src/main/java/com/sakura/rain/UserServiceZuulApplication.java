package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-17
 */
@SpringBootApplication
@EnableZuulProxy
public class UserServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceZuulApplication.class, args);
    }
}
