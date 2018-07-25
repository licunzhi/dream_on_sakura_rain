package com.meimei.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-20
 */
@Component
public class ProduceRabbitComponent {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0 * * * * *") // 每分钟发送一次数据信息
    public void sendRabbitMessage() {
        String message = UUID.randomUUID().toString();
        System.out.println(message);
        rabbitTemplate.convertAndSend("queue_one", message);
        rabbitTemplate.convertAndSend("queue_two", message);
    }

}
