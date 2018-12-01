package com.sakura.rain.configuration;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.RoundRobinRule;
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

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AbstractLoadBalancerRule getBalanceRule() {
        return new RoundRobinRule();//默认机制
        //return new RandomRule();//随机策略
        //return new RetryRule();//默认轮训的机制上有纠错的恢复功能
    }
}
