package com.plum.park.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName KafkaConsumer
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/03/24 15:16
 */
@RestController
@RequestMapping("/producer")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/count/{count}")
    public String producer(@PathVariable(value = "count") Integer count) {
        for (Integer i = 0; i < count; i++) {
            kafkaTemplate.send("first", System.currentTimeMillis() + "--" + UUID.randomUUID().toString());
        }
        return "success";
    }
}
