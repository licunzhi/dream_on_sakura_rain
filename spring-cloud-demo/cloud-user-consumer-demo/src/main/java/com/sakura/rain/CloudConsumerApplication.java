package com.sakura.rain;

import com.sakura.irules.MyRukes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author licunzhi
 * @desc 消费端启动类
 * @date 2018-11-29
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-USER-SERVICE-DEMO", configuration = MyRukes.class) //启动自定义的策略
@EnableDiscoveryClient //消费端对于服务发现功能
public class CloudConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerApplication.class, args);
    }
}
