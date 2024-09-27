package com.example.kafkaapp.controller;

import com.example.kafkaapp.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final RabbitMQProducer producer;

    @GetMapping()
    public void create(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }
}
