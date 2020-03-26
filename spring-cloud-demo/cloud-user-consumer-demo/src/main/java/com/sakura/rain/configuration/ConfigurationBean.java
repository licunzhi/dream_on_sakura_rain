package com.sakura.rain.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author licunzhi
 * @desc 初始化配置
 * @date 2018-11-29
 */
@Configuration
public class ConfigurationBean {

    /**
     * 负载调用工具
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*@Bean
    public AbstractLoadBalancerRule getBalanceRule() {
        *//*随机策略*//*
        //return new RandomRule();
        *//*默认轮训的机制上有纠错的恢复功能*//*
        //return new RetryRule();
        *//*默认机制*//*
        return new RoundRobinRule();
    }*/
}
