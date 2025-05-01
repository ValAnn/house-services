package com.example.house_services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.house_services.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
