package com.practice.forum.services;

import com.practice.forum.dtos.ForumRequestDto;
import com.practice.forum.models.Forum;
import org.springframework.stereotype.Service;

@Service
public class ForumService {
    public Forum addForum(ForumRequestDto forumRequestDto) {
        Forum forum = new Forum();
        forum.setTitle("Forum-1");
        return forum;
    }
}
