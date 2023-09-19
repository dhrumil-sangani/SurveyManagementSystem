package com.spec.surveymanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.surveymanagementsystem.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
//    User findByEmail(String email);
    public Optional<User>findByEmail(String email);
}
