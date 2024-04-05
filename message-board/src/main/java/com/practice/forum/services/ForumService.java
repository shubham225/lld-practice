package com.practice.forum.services;

import com.practice.forum.dtos.ForumRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.User;
import com.practice.forum.repositories.ForumRepository;
import com.practice.forum.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ForumService {

    private final UserRepository userRepository;
    private final ForumRepository forumRepository;

    public ForumService(UserRepository userRepository,
                        ForumRepository forumRepository) {
        this.userRepository = userRepository;
        this.forumRepository = forumRepository;
    }

    public Forum addForum(ForumRequestDto forumRequestDto) {
        Forum forum = new Forum();
        forum.setTitle(forumRequestDto.getTitle());
        forum.setMetadata(forumRequestDto.getMetadata());

        Optional<User> userOptional = userRepository.findById(forumRequestDto.getCreatedById());

        if(userOptional.isEmpty())
            throw new RuntimeException("User not found");

        forum.setCreatedBy(userOptional.get());
        forum.setCreatedAt(new Date());

        forum = forumRepository.save(forum);

        return forum;
    }

    public Forum getForum(long forumId) {
        Optional<Forum> forumOptional = forumRepository.findById(forumId);

        if(forumOptional.isEmpty())
            throw new RuntimeException("Forum not found");

        return forumOptional.get();
    }
}
