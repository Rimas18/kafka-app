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
public class CustomerResource {
    private Long id;
    private Long userId;
    private String customerNo;
}
