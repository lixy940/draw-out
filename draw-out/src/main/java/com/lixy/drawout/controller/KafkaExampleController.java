package com.lixy.drawout.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Author：MR LIS，2019/9/27
 * Copyright(C) 2019 All rights reserved.
 */
@RestController
@RequestMapping("/kafka")
public class KafkaExampleController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void sendKafka(HttpServletRequest request) {
        try {
            String message = request.getParameter("message");
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("topic_1", "key", message);
            logger.info("发送kafka成功.");
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
        }
    }


    @RequestMapping(value = "/send_2", method = RequestMethod.GET)
    public void sendKafka_2(HttpServletRequest request) {
        try {
            String message = request.getParameter("message");
            logger.info("kafka的消息={}", message);
            kafkaTemplate.send("topic_2", message);
            logger.info("发送kafka成功.");
        } catch (Exception e) {
            logger.error("发送kafka失败", e);
        }
    }
}

