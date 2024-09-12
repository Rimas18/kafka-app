package com.example.kafkaap.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic emailMessageTopicLow() {
        return new NewTopic("emailMessageTopicLow", 1, (short) 1);
    }

//    @Bean
//    public NewTopic emailMessageTopicMedium() {
//        return new NewTopic("emailMessageTopicMedium", 1, (short) 1);
//    }
//
//    @Bean
//    public NewTopic emailMessageTopicHigh() {
//        return new NewTopic("emailMessageTopicHigh", 1, (short) 1);
//    }
}
