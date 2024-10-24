package com.example.HW4.post.controller;

import com.example.HW4.post.dto.PostRequest;
import com.example.HW4.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/{userId}")
    public void CreatePost(@PathVariable Long userId, @RequestBody PostRequest.PostCreateRequest req){
        postService.createPost(userId, req);
    }
}
