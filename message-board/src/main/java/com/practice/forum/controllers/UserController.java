package com.practice.forum.controllers;

import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.Forum;
import com.practice.forum.models.User;
import com.practice.forum.repositories.UserRepository;
import com.practice.forum.services.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/V1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            path = "/add"
    )
    public User addUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.addUser(userRequestDto);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{userId}"
    )
    public User getForum(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}
