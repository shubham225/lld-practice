package com.practice.forum.controllers;

import com.practice.forum.dtos.PostRequestDto;
import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.Post;
import com.practice.forum.models.User;
import com.practice.forum.services.PostService;
import com.practice.forum.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/add"
    )
    public Post addUser(@RequestBody PostRequestDto postRequestDto) {
        return postService.addPost(postRequestDto);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all/{threadId}"
    )
    public List<Post> getPosts(@PathVariable Long threadId) {
        return postService.getPosts(threadId);
    }
}
