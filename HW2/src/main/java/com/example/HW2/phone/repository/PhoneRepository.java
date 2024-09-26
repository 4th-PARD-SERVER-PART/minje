package com.example.HW2.phone.repository;

import com.example.HW2.phone.dto.PhoneDto;
import com.example.HW2.phone.entity.Phone;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PhoneRepository {
    private static final Map<Long, Phone> phoneMap = new HashMap<>();

    public void save(PhoneDto phoneDto){
        Phone phone = Phone.builder()
                .phoneNumber(phoneDto.getPhoneNumber())
                .phoneName(phoneDto.getPhoneName())
                .phonePrice(phoneDto.getPhonePrice())
                .build();
        phoneMap.put(phoneDto.getPhoneNumber(), phone);
    }

    public PhoneDto getByNumber(Long phoneNumber){
        Phone phone = phoneMap.get(phoneNumber);
        return PhoneDto.builder()
                .phoneNumber(phone.getPhoneNumber())
                .phoneName(phone.getPhoneName())
                .phonePrice(phone.getPhonePrice())
                .build();
    }

    public List<PhoneDto> getList() {
        return phoneMap.values().stream()
                .map(phone->PhoneDto.builder()
                        .phoneNumber(phone.getPhoneNumber())
                        .phoneName(phone.getPhoneName())
                        .phonePrice(phone.getPhonePrice())
                        .build()).toList();

    }

    public void updatePhone(Long phoneNumber, PhoneDto phoneDto) {
        Phone phone = phoneMap.get(phoneNumber);
        phone.setPhoneNumber(phoneDto.getPhoneNumber());
        phone.setPhoneName(phone.getPhoneName());
        phone.setPhonePrice(phoneDto.getPhonePrice());
    }

    public void delete(Long phoneNumber) {
        phoneMap.remove(phoneNumber);
    }
}
