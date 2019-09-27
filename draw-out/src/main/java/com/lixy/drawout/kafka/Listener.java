package com.lixy.drawout.kafka;

/**
 * Author：MR LIS，2019/9/25
 * Copyright(C) 2019 All rights reserved.
 */
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());


    @KafkaListener(topics = {"topic_1"})
    public void listen_1(ConsumerRecord<?, ?> record) {
        logger.info("topic_1 ==== kafka的key: " + record.key());
        logger.info("topic_1 ==== kafka的value: " + record.value());
    }

    @KafkaListener(topics = {"topic_2"})
    public void listen_2(ConsumerRecord<?, ?> record) {
        logger.info("topic_2 ====  kafka的value: " + record.value());
    }

}