package com.example.kafkaapp.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer")
@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: Generates a no-args constructor
@AllArgsConstructor // Lombok: Generates an all-args constructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy fetch type for optimization
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "customer_no", nullable = false)
    private String customerNo;
}
