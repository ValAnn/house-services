package com.example.house_services.services;

import org.springframework.stereotype.Service;

import com.example.house_services.models.User;
import com.example.house_services.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
