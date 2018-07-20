package com.meimei;

import com.rabbitmq.client.Channel;
import com.utils.ConnectionUtil;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @author licunzhi
 * @desc 服务端（生产者）
 * @date 2018-07-20
 */
public class Server {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = ConnectionUtil.initConnetion();
        for (int i =0; i < 100; i++) {
            String message = UUID.randomUUID().toString();
            channel.basicPublish("", ConnectionUtil.QUEUE_NAME, null, message.getBytes("UTF-8"));
            //定時發送消息  展示結果更加明顯
            Thread.sleep(10000);
        }
    }
}
