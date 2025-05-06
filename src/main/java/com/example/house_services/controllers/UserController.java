package com.example.house_services.controllers;

import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.example.house_services.repositories.UserRepository;
import com.example.house_services.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepo;

    @GetMapping
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userRepo.save(user);
    }

    
    
}
