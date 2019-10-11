package com.plum.park.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @ClassName SRKafkaTemplate
 * @Description kafka模板的初始数据
 * @Author lcz
 * @Date 2019/10/09 09:30
 */
@Component
public class SRKafkaTemplate {

    private final KafkaTemplate kafkaTemplate;

    @Autowired
    public SRKafkaTemplate(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
}
