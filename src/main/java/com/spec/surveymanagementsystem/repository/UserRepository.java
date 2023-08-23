package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.surveymanagementsystem.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
