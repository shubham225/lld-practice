package com.practice.forum.controllers;

import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.User;
import com.practice.forum.repositories.UserRepository;
import com.practice.forum.services.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public User addUser(UserRequestDto userRequestDto) {
        return userService.addUser(userRequestDto);
    }
}
