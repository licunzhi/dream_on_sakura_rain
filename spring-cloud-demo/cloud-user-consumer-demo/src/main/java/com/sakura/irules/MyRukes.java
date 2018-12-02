package com.sakura.irules;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-12-02
 */
@Configuration
public class MyRukes {

    @Bean
    public IRule myRule()
    {
        //return new RandomRule();// Ribbon默认是轮询，我自定义为随机
        //return new RoundRobinRule();// Ribbon默认是轮询，我自定义为随机

        return new RandomRule_3_Times();// 我自定义为每台机器5次
    }
}
