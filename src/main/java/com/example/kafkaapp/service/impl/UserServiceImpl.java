package com.example.kafkaapp.service.impl;

import com.example.kafkaapp.dto.CustomerResource;
import com.example.kafkaapp.dto.UserResource;
import com.example.kafkaapp.entity.User;
import com.example.kafkaapp.repostiroy.UserRepository;
import com.example.kafkaapp.service.UserService;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KafkaTemplate<Long, Object> kafkaTemplate;

    @Override
    public void create(UserResource resource) {
        User user = userRepository.save(User.builder()
                .fullname(resource.getFullName())
                .age(resource.getAge())
                .build());

        CustomerResource customerResource = CustomerResource.builder()
                .userId(user.getId())
                .customerNo(generateCustomerNo(user.getId()))
                .build();
        kafkaTemplate.send("customerTopic", user.getId(), customerResource);
    }

    private String generateCustomerNo(Long userId) {
        long timestamp = System.currentTimeMillis();
        return "CUS-" + userId + "-" + timestamp;
    }

}
