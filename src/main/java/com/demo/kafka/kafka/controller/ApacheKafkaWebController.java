package com.demo.kafka.kafka.controller;

import com.demo.kafka.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka/producer/")
public class ApacheKafkaWebController {

    final KafkaProducer kafkaProducer;
    @Value(value = "${message.topic.name}")
    private String topicName;

    public ApacheKafkaWebController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping(value = "/greetings")
    public String producer(@RequestParam("message") String message) {
        kafkaProducer.send(message);
        return "Message sent to the Kafka Topic "+topicName+" Successfully";
    }
}
