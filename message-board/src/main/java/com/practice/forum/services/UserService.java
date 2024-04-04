package com.practice.forum.services;

import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User addUser(UserRequestDto userRequestDto) {
        User user = new User();

        user.setName("shubham");
        user.setEmail("shubham@gmail.com");
        return user;
    }
}
