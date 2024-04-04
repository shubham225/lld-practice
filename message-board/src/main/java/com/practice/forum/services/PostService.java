package com.practice.forum.services;

import com.practice.forum.dtos.PostRequestDto;
import com.practice.forum.models.Post;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    public Post addPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setMessage("Post-1");
        return post;
    }
}
