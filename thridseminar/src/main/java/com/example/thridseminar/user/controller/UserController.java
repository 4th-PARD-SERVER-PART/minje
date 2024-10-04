package com.example.thridseminar.user.controller;

import com.example.thridseminar.user.dto.UserDto;
import com.example.thridseminar.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto readById(@PathVariable Long userId) {
        return userService.read(userId);
    }

    @GetMapping("")
    public List<UserDto> readAll() {
        return userService.readAll();
    }

    @PatchMapping("/{userId}")
    public void update(@PathVariable Long userId, @RequestBody UserDto userDto) {
        userService.update(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

    @GetMapping("/userEmail")
    public ResponseEntity<Long> readByEmail(@RequestParam String email){
        Long responseValue = userService.getUserNum(email);
        return new ResponseEntity<>(responseValue, HttpStatus.OK);
    }

}
