package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-02
 */
@SpringBootApplication(scanBasePackages = {"com.sakura.rain"})
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.sakura.rain"})
public class UserConsumerFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserConsumerFeignApplication.class, args);
    }
}
