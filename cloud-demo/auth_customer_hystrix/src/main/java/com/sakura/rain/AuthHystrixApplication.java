package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName AuthApplication
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 10:25
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
// 开启客户端
@EnableEurekaClient
// 开启feign
@EnableFeignClients
// 开启Hystrix
@EnableHystrix
// 开启熔断机制
@EnableCircuitBreaker
public class AuthHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthHystrixApplication.class, args);
    }
}
