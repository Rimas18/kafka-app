package com.example.kafkaapp.repostiroy;

import com.example.kafkaapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
