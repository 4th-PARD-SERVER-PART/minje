package com.example.HW4.post.service;

import com.example.HW4.post.dto.PostRequest;
import com.example.HW4.post.dto.PostResponse;
import com.example.HW4.post.entity.Post;
import com.example.HW4.post.repository.PostRepository;
import com.example.HW4.user.entity.User;
import com.example.HW4.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void createPost(Long userId, PostRequest.PostCreateRequest req){
        Optional<User> u = userRepository.findById(userId);
        User user = u.get();
        Post post = Post.from(req.getTitle(), req.getContent(), user);
        postRepository.save(post);
    }

    public PostResponse.PostReadResponse readPost(Long postId){
        Optional<Post> b = postRepository.findById(postId);
        Post post = b.get();
        return new PostResponse.PostReadResponse(postId, post.getTitle(), post.getContent());
    }
}
