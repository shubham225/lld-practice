package com.practice.forum.controllers;

import com.practice.forum.dtos.ForumRequestDto;
import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.User;
import com.practice.forum.services.ForumService;
import com.practice.forum.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/V1/forum")
public class ForumController {
    private final ForumService forumService;

    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/add"
    )
    public Forum addForum(@RequestBody ForumRequestDto forumRequestDto) {
        return forumService.addForum(forumRequestDto);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{forumId}"
    )
    public Forum getForum(@PathVariable Long forumId) {
        return forumService.getForum(forumId);
    }
}
