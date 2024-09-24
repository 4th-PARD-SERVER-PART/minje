package com.example.HW2.phone.controller;

import com.example.HW2.phone.dto.PhoneDto;
import com.example.HW2.phone.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/phone")
public class PhoneController {
    private final PhoneService phoneService;

    @PostMapping("")
    public void savePhone(@RequestBody PhoneDto phoneDto) {
        phoneService.savePhone(phoneDto);
    }

    @GetMapping("/{phoneNumber}")
    public PhoneDto getByNumber(@PathVariable Long phoneNumber) {
        return phoneService.getByNumber(phoneNumber);
    }

    @GetMapping("")
    public List<PhoneDto> getList() {
        return phoneService.getList();
    }

    @PatchMapping("/{phoneNumber}")
    public String updatePhone(@PathVariable Long phoneNumber, @RequestBody PhoneDto phoneDto) {
        phoneService.updatePhone(phoneNumber, phoneDto);
        return "수정되엇습니다.";
    }

    @DeleteMapping("/{phoneNumber}")
    public String deletePhone(@PathVariable Long phoneNumber) {
        phoneService.delete(phoneNumber);
        return "삭제되었습니다";

    }
}
