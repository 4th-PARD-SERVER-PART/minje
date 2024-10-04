package com.example.HW3.burgerking.repository;

import com.example.HW3.burgerking.entity.Burgerking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BurgerkingRepository extends JpaRepository<Burgerking, Long> {
    //public Burgerking findById(Long userId);
    public Burgerking findByName(String name);
    public Burgerking findAllByOrderByPriceAsc();
}
