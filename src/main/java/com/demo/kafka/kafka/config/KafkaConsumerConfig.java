package com.demo.kafka.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import java.util.concurrent.CountDownLatch;

@Configuration
public class KafkaConsumerConfig {
    public static Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
    private final CountDownLatch latch = new CountDownLatch(3);


    @KafkaListener(topics = "${message.topic.name}", groupId = "1")
    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
        logger.info(cr.toString());
        System.out.println(cr.value());
        latch.countDown();
    }
}
