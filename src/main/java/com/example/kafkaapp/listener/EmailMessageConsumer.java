package com.example.kafkaapp.listener;

import com.example.kafkaapp.dto.CustomerResource;
import com.example.kafkaapp.entity.Customer;
import com.example.kafkaapp.entity.User;
import com.example.kafkaapp.repostiroy.CustomerRepository;
import com.example.kafkaapp.repostiroy.UserRepository;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailMessageConsumer {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private int count = 0;

    @RetryableTopic(
            attempts = "5",                                      // Maximum number of retry attempts
            backoff = @Backoff(delay = 5000, multiplier = 2),  // Exponential backoff with an initial delay of 1 second
            autoCreateTopics = "false",                        // Topics will be created if they don't exist
            dltStrategy = DltStrategy.FAIL_ON_ERROR            // Messages will be sent to a dead-letter topic if retries fail
    )
    @KafkaListener(topics = "customerTopic", groupId = "costumer-group")
    public void consume(CustomerResource resource) {
        count++;
        System.out.println("Received with message: " + resource.getCustomerNo() + "retryCount:" + count);

        if (Math.random() > 0.5) {
            throw new RuntimeException("Simulated random failure in Listener");
        }

        count=0;
        User user = userRepository.findById(resource.getUserId());
        Customer customer = new Customer();
        customer.setCustomerNo(resource.getCustomerNo());
        customer.setUser(user);
        customerRepository.save(customer);
    }
}
