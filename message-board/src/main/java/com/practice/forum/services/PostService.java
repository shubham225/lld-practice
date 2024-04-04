package com.practice.forum.services;

import com.practice.forum.dtos.PostRequestDto;
import com.practice.forum.models.Post;
import com.practice.forum.models.Thread;
import com.practice.forum.models.User;
import com.practice.forum.repositories.PostRepository;
import com.practice.forum.repositories.ThreadRepository;
import com.practice.forum.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PostService {

    private final UserRepository userRepository;
    private final ThreadRepository threadRepository;
    private final PostRepository postRepository;

    public PostService(UserRepository userRepository,
                       ThreadRepository threadRepository,
                       PostRepository postRepository) {
        this.userRepository = userRepository;
        this.threadRepository = threadRepository;
        this.postRepository = postRepository;
    }

    public Post addPost(PostRequestDto postRequestDto) {
        Post post = new Post();
        post.setMessage(postRequestDto.getMessage());

        Optional<User> userOptional = userRepository.findById(postRequestDto.getCreatedById());
        Optional<Thread> threadOptional = threadRepository.findById(postRequestDto.getThreadId());

        if(userOptional.isEmpty())
            throw new RuntimeException("User not found");

        if(threadOptional.isEmpty())
            throw new RuntimeException("Thread not found");

        if (postRequestDto.getReplyToPostId() != 0) {
            Optional<Post> replyPostOptional = postRepository.findById(postRequestDto.getReplyToPostId());

            if(replyPostOptional.isEmpty())
                throw new RuntimeException("Post not found");

            post.setReplyTo(replyPostOptional.get());
        }else {
            post.setReplyTo(null);
        }

        post.setThread(threadOptional.get());
        post.setCreatedBy(userOptional.get());
        post.setCreatedAt(new Date());

        post = postRepository.save(post);
        return post;
    }
}
