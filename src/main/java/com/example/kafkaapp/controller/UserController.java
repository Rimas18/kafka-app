package com.example.kafkaapp.controller;

import com.example.kafkaapp.dto.UserResource;
import com.example.kafkaapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @PostMapping()
    public void create(@RequestBody UserResource resource) {
        service.create(resource);
    }
}
