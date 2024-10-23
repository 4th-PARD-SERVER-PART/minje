package com.example.HW4.user.dto;

import com.example.HW4.post.entity.Post;
import com.example.HW4.user.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReadRequest {
        private Long id;
        private String name;
        private List<Post> posts;

        public static UserReadRequest from(User u) {
            return new UserReadRequest(u.getId(), u.getName(), u.getPosts());
        }
    }

    @Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequest{
        private String name;
        private List<Post> posts;
    }
}
