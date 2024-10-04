package com.example.HW3.burgerking.controller;

import com.example.HW3.burgerking.dto.BurgerkingDto;
import com.example.HW3.burgerking.entity.Burgerking;
import com.example.HW3.burgerking.service.BurgerkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/burgerking")
public class BurgerkingController {
    private final BurgerkingService burgerkingService;

    @PostMapping("")
    public void save(@RequestBody BurgerkingDto burgerkingDto) {
        burgerkingService.save(burgerkingDto);
    }

    @GetMapping("/{userId}")
    public BurgerkingDto readById(@PathVariable Long userId) {
        return burgerkingService.read(userId);
    }

    @GetMapping("")
    public List<BurgerkingDto> readAll() {
        return burgerkingService.readAll();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody BurgerkingDto burgerkingDto) {
        burgerkingService.update(userId, burgerkingDto);
    }

    @DeleteMapping("/userId")
    public void delete(@PathVariable Long userId) {
        burgerkingService.delete(userId);
    }

    @GetMapping("/priceAsc")
    public Burgerking findPriceAsc() {
        return burgerkingService.findPriceAsc();
    }
    @GetMapping("/{name}")
    public ResponseEntity<Long> findId(@RequestParam String name){
        Long responseValue = burgerkingService.findId(name);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }

}
