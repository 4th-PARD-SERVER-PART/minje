package com.example.HW4.user.dto;

import com.example.HW4.post.dto.PostResponse;
import com.example.HW4.user.entity.User;
import lombok.*;

import java.util.List;

public class UserResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadUser{
        private String name;
        private List<PostResponse.PostReadResponse> posts;

        public static ReadUser from(User user){
            return new ReadUser(user.getName(),
                    PostResponse.PostReadResponse.postToDto(user.getPosts()));
        }
    }
}
