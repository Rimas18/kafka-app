package com.example.kafkaapp.service;

import com.example.kafkaapp.dto.UserResource;

public interface UserService {
    void create(UserResource resource);
}
