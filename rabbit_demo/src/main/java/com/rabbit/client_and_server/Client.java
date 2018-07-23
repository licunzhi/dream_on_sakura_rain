package com.rabbit.client_and_server;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbit.utils.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author licunzhi
 * @desc 客户端（消费者）
 * @date 2018-07-20
 */
public class Client {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = ConnectionUtil.initConnetion();
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                            AMQP.BasicProperties properties, byte[] body)
                            throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };
        channel.basicConsume( ConnectionUtil.QUEUE_NAME, true, consumer);
    }
}
