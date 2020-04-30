package com.sakura.rain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author licunzhi
 * @desc cloud config 启动类
 *
 * /{application}/{profile}[/{label}]
 *
 *   /{application}-{profile}.yml
 *
 *   /{label}/{application}-{profile}.yml
 *
 *   /{application}-{profile}.properties
 *
 *   /{label}/{application}-{profile}.properties
 * @date 2018-12-27
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerApplication.class, args);
    }
}
