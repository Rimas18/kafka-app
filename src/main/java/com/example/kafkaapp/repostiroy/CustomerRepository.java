package com.example.kafkaapp.repostiroy;

import com.example.kafkaapp.entity.Customer;
import com.example.kafkaapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
