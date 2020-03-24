package com.plum.park.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @ClassName KafkaConsumer
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/03/24 15:23
 */
@Component
@Slf4j
public class KafkaConsumer {

    private static int num = 0;

    @KafkaListener(topics = { "first" })
    public void consume(ConsumerRecord<?, ?> consumerRecord) {
        /*睡眠一段时间，表现  生产者 > 消费者能力*/
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long offset = consumerRecord.offset();
        log.info("offset: {}", offset);

        if (!Objects.isNull(consumerRecord.value())) {
            num++;
            log.info(">>>>>>>>>>>>Kafka message is {}", consumerRecord.value().toString());
            log.info("message: " + consumerRecord.value());
            log.info("num: " + num);
        }
    }
}
