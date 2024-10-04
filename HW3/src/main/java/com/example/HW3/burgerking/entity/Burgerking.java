package com.example.HW3.burgerking.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Burgerking {
    @Id
    @GeneratedValue
    private Long userId;

    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "price")
    private Long price;

    @CreationTimestamp
    private Timestamp userSignupTime;

}
