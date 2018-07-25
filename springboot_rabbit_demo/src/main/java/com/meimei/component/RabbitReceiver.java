package com.meimei.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-07-20
 */
@Component
public class RabbitReceiver {

    @RabbitListener(queues = "queue_one")
    public void receiveMessage(String message) throws UnsupportedEncodingException {
            System.out.println("收到分组one的数据信息: " + message);
    }

    @RabbitListener(queues = "queue_two")
    public void receiveMessageTwo(String message) throws UnsupportedEncodingException {
        System.out.println("收到分组two的数据信息: " + message);
    }
}
