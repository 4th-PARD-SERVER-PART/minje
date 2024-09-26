package com.example.HW2.phone.service;

import com.example.HW2.phone.dto.PhoneDto;
import com.example.HW2.phone.entity.Phone;
import com.example.HW2.phone.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneRepository phoneRepository;

    public void savePhone(PhoneDto phoneDto) {
        phoneRepository.save(phoneDto);
    }

    public PhoneDto getByNumber(Long phoneNumber) {
        return phoneRepository.getByNumber(phoneNumber);
    }

    public List<PhoneDto> getList() {
        return phoneRepository.getList();
    }

    public void updatePhone(Long phoneNumber, PhoneDto phoneDto){
        phoneRepository.updatePhone(phoneNumber, phoneDto);
    }

    public void delete(Long phoneNumber) {
        phoneRepository.delete(phoneNumber);
    }
}
