package com.practice.forum.controllers;

import com.practice.forum.dtos.ThreadRequestDto;
import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.Thread;
import com.practice.forum.models.User;
import com.practice.forum.services.ThreadService;
import com.practice.forum.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Thread addThread(ThreadRequestDto threadRequestDto) {
        return threadService.addThread(threadRequestDto);
    }
}
