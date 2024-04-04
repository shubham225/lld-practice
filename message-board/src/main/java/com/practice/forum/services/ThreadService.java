package com.practice.forum.services;

import com.practice.forum.dtos.ThreadRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.Thread;
import com.practice.forum.models.User;
import com.practice.forum.repositories.ForumRepository;
import com.practice.forum.repositories.ThreadRepository;
import com.practice.forum.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ThreadService {

    private final UserRepository userRepository;
    private final ForumRepository forumRepository;
    private final ThreadRepository threadRepository;

    public ThreadService(UserRepository userRepository,
                         ForumRepository forumRepository,
                         ThreadRepository threadRepository) {
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
        this.threadRepository = threadRepository;
    }

    public Thread addThread(ThreadRequestDto threadRequestDto) {
        Thread thread = new Thread();
        thread.setTitle(threadRequestDto.getTitle());
        thread.setMetadata(threadRequestDto.getMetadata());

        Optional<User> userOptional = userRepository.findById(threadRequestDto.getCreatedById());
        Optional<Forum> forumOptional = forumRepository.findById(threadRequestDto.getForumId());

        if(userOptional.isEmpty())
            throw new RuntimeException("User not found");

        if(forumOptional.isEmpty())
            throw new RuntimeException("Forum not found");

        thread.setForum(forumOptional.get());
        thread.setCreatedBy(userOptional.get());
        thread.setCreatedAt(new Date());

        thread = threadRepository.save(thread);

        return thread;
    }
}
