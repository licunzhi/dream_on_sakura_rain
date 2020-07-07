package com.plum.park.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @ClassName ProductDemo
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/07 09:29
 */
public class ProductDemo {
    private static final String URLS = "192.168.198.131:9092,192.168.198.132:9092,192.168.198.133:9092";
    private static final String TOPICS = "licunzhi";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, URLS);
        properties.put(ProducerConfig.RETRIES_CONFIG, 0);

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("睡眠停顿...");
            }
            ProducerRecord<String, String> record = new ProducerRecord<>(TOPICS, String.valueOf(System.currentTimeMillis()), "Demo-" + System.currentTimeMillis());
            kafkaProducer.send(record);
        }

        kafkaProducer.close();

    }
}
