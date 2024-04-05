package com.practice.forum.controllers;

import com.practice.forum.dtos.ThreadRequestDto;
import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.Thread;
import com.practice.forum.models.User;
import com.practice.forum.services.ThreadService;
import com.practice.forum.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/V1/thread")
public class ThreadController {
    private final ThreadService threadService;

    public ThreadController(ThreadService threadService) {
        this.threadService = threadService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            path = "/add"
    )
    public Thread addThread(@RequestBody ThreadRequestDto threadRequestDto) {
        return threadService.addThread(threadRequestDto);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/all/{forumId}"
    )
    public List<Thread> getThreads(@PathVariable Long forumId) {
        return threadService.getThreads(forumId);
    }
}
