package com.example.kafkaap.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailMessageConsumer {

    @KafkaListener(topics = "emailMessageTopicLow", groupId = "email-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
        // You can add your logic to process the received message here
    }
}
