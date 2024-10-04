package com.example.HW3.burgerking.service;

import com.example.HW3.burgerking.dto.BurgerkingDto;
import com.example.HW3.burgerking.entity.Burgerking;
import com.example.HW3.burgerking.repository.BurgerkingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BurgerkingService {
    private final BurgerkingRepository burgerkingRepository;

    public void save(BurgerkingDto burgerkingDto) {
        Burgerking burgerking = Burgerking.builder()
                .name(burgerkingDto.getName())
                .price(burgerkingDto.getPrice())
                .build();
        burgerkingRepository.save(burgerking);

    }

    public BurgerkingDto read(Long userId) {
        Burgerking burgerking = burgerkingRepository.findById(userId).get();
        return BurgerkingDto.builder()
                .name(burgerking.getName())
                .price(burgerking.getPrice())
                .build();

    }

    public List<BurgerkingDto> readAll() {
        List<Burgerking> burgerkings = burgerkingRepository.findAll();
        List<BurgerkingDto> burgerkingDtos = burgerkings.stream().map(burgerking ->
                BurgerkingDto.builder()
                        .name(burgerking.getName())
                        .price(burgerking.getPrice())
                        .build()).toList();
        return burgerkingDtos;
    }

    public void update(Long userId, BurgerkingDto burgerkingDto) {
        Burgerking burgerking = burgerkingRepository.findById(userId).get();
        burgerking.setName(burgerkingDto.getName());
        burgerking.setPrice(burgerkingDto.getPrice());
        burgerkingRepository.save(burgerking);
    }

    public void delete(Long userId) {
        burgerkingRepository.deleteById(userId);
    }

    public List<Burgerking> getAllOrderedByPrice() {
        return burgerkingRepository.findAllByOrderByPriceAsc();
    }

    public Long findIdByName(String name){
        Burgerking burgerking = burgerkingRepository.findByName(name);
        return burgerking.getUserId();
    }

    public Long findIdByPrice(Long price){
        Burgerking burgerking = burgerkingRepository.findByPrice(price);
        return burgerking.getUserId();
    }
}
