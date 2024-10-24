package com.example.HW4.post.dto;

import com.example.HW4.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class PostResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostReadResponse{
        private Long postId;
        private String title;
        private String content;

        public static List<PostReadResponse> postToDto(List<Post> posts){
            List<PostReadResponse> ret = new ArrayList<>();
            for(Post post : posts){
                PostReadResponse p =
                        new PostReadResponse(post.getId(), post.getTitle(), post.getContent());
                ret.add(p);
            }
            return ret;
        }
    }
}
