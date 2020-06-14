package com.sakura.rain;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

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
@EnableCircuitBreaker
@EnableHystrixDashboard
public class AuthFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthFeignApplication.class, args);
    }
}
