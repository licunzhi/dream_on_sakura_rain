package com.plum.park.component;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @ClassName KafkaConsumer
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/10/08 17:16
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener()
    public void consumerFirstTest(ConsumerRecord<String, Object> record, @Header(KafkaHeaders.RECEIVED_TOPIC)
            String topic, Consumer consumer, Acknowledgment acknowledgment) {
        log.info("consumer first information ... ");
        log.info("单独消费者消费消息,topic= {} ,content = {}",topic,record.value());
        log.info("consumer content = {}",consumer);
        acknowledgment.acknowledge();
    }
}
