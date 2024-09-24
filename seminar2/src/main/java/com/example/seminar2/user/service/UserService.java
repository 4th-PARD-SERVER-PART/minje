package com.example.seminar2.user.service;

import com.example.seminar2.user.dto.UserDto;
import com.example.seminar2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(UserDto userDto) {
        userRepository.save(userDto);
    }
    public UserDto findById(long studentId) {
        return userRepository.findById(studentId);
    }
    public List<UserDto> findAll() {
        return userRepository.findAll();
    }
    public void update(Long studentId, UserDto userDto) {
        userRepository.update(studentId, userDto);
    }
    public void delete(Long studentId) {
        userRepository.delete(studentId);
    }
}
