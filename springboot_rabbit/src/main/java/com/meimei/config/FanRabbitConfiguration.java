package com.meimei.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author licunzhi
 * @desc 交换、路由配置
 * @date 2018-07-20
 */
@Configuration
public class FanRabbitConfiguration {

    @Bean
    public Queue queueOne() {
        return new Queue("queue_one");
    }

    @Bean
    FanoutExchange fanoutExchangeOne() {
        return new FanoutExchange("fanout_one", false, false);
    }

    @Bean
    Binding bindingExchangeA(Queue queueOne, FanoutExchange fanoutExchangeOne) {
        return BindingBuilder.bind(queueOne).to(fanoutExchangeOne);
    }

    @Bean
    public Queue queueTwo() {
        return new Queue("queue_two");
    }

    @Bean
    FanoutExchange fanoutExchangeTwo() {
        return new FanoutExchange("fanout_two", false, false);
    }

    @Bean
    Binding bindingExchangeTwo(Queue queueTwo, FanoutExchange fanoutExchangeTwo) {
        return BindingBuilder.bind(queueTwo).to(fanoutExchangeTwo);
    }

}
