package com.example.kafkaap.controller;

import com.example.kafkaap.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService service;

    @PostMapping("/test")
    public void test(@RequestParam(name = "message") String message) {
        service.test(message);
    }
}
