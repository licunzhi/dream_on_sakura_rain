package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApplication01
 * @function [eureka注册中心01]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 09:21
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer // 开启eureka服务
public class EurekaApplication02 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication02.class, args);
    }
}
