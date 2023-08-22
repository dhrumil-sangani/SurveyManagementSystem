package com.spec.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.sms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
