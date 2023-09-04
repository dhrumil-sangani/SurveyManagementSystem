package com.spec.surveymanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.surveymanagementsystem.model.DummyUser;

public interface DummyUserRepository extends JpaRepository<DummyUser, String> {
	public Optional<DummyUser>findByEmail(String email);
}
