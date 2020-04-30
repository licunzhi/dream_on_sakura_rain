package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author licunzhi
 * @desc 启动类
 * @date 2018-11-29
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class CloudConfigClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClientDemoApplication.class, args);
    }
}
