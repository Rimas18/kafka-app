package com.example.kafkaapp.dto;

import com.example.kafkaapp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResource {
    private Long id;
    private String fullName;
    private Integer age;

    public static UserResource from(User user) {
        return UserResource.builder()
                .id(user.getId())
                .fullName(user.getFullname())
                .age(user.getAge())
                .build();
    }
}
