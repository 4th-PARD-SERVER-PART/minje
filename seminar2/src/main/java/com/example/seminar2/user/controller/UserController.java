package com.example.seminar2.user.controller;

import com.example.seminar2.user.dto.UserDto;
import com.example.seminar2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/{studentId}")
    public UserDto findById(@PathVariable Long studentId) {
        return userService.findById(studentId);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PatchMapping("/{studentId}")
    public String update(@PathVariable Long studentId, @RequestBody UserDto userDto) {
        userService.update(studentId, userDto);
        return "수정됨";
    }

    @DeleteMapping("/{studentId}")
    public String deleteById(@PathVariable Long studentId) {
        userService.delete(studentId);
        return "삭제되었음";
    }
}
