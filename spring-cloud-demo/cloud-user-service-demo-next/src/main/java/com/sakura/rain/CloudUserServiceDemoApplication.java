package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author licunzhi
 * @desc 启动类
 * @date 2018-11-29
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudUserServiceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUserServiceDemoApplication.class, args);
    }
}
