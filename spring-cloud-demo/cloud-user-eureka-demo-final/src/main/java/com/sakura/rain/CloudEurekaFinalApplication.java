package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-29
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaFinalApplication.class, args);
    }
}
