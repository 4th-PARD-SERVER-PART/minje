package com.example.HW4.user.service;

import com.example.HW4.user.dto.UserRequest;
import com.example.HW4.user.dto.UserResponse;
import com.example.HW4.user.entity.User;
import com.example.HW4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse.ReadUser readUser(Long id) {
        Optional<User> u = userRepository.findById(id);
        User user = u.get();
        UserResponse.ReadUser ret = UserResponse.ReadUser.from(user);
        return ret;
    }

    public void createUser(UserRequest.UserCreateRequest req){
        User u = new User(null, req.getName(), req.getPosts());
        userRepository.save(u);
    }

    public void deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        userRepository.delete(user);
    }
}

