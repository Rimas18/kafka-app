package com.example.kafkaap.service.impl;

import com.example.kafkaap.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void test(String message) {
        kafkaTemplate.send("emailMessageTopicLow",message);
    }
}
