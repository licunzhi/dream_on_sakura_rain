package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

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
@EnableTurbine
@EnableHystrixDashboard
public class AuthTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthTurbineApplication.class, args);
    }

}
