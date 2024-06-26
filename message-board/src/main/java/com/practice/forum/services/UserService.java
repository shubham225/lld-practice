package com.practice.forum.services;

import com.practice.forum.dtos.UserRequestDto;
import com.practice.forum.exceptions.UserNotFoundException;
import com.practice.forum.models.User;
import com.practice.forum.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPhone(userRequestDto.getPhone());

        user = userRepository.save(user);

        return user;
    }

    public User getUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty())
            throw new UserNotFoundException();

        return userOptional.get();
    }
}
