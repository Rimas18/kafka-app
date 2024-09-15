package com.example.kafkaapp.repostiroy;

import com.example.kafkaapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findById(Long id);
}
