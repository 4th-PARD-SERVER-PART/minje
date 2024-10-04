package com.example.HW3.burgerking.repository;

import com.example.HW3.burgerking.entity.Burgerking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BurgerkingRepository extends JpaRepository<Burgerking, Long> {
    public Burgerking findByPrice(Long price);
    public Burgerking findByName(String name);
    List<Burgerking> findAllByOrderByPriceAsc();
}
