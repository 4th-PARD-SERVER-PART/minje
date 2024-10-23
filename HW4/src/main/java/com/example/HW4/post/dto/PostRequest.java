package com.example.HW4.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostCreateRequest {
        private String title;
        private String content;
    }
}
