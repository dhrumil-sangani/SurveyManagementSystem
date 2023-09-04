package com.spec.surveymanagementsystem.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.DummyUser;
import com.spec.surveymanagementsystem.repository.DummyUserRepository;
import com.spec.surveymanagementsystem.repository.UserRepository;

@Service
public class UserService {
	private List<DummyUser> store = new ArrayList<>();
	
	@Autowired
	private DummyUserRepository dummyUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public List<DummyUser> getUser() {
		return dummyUserRepository.findAll();
	}
	
	public DummyUser createUser(DummyUser dummyUser) {
		dummyUser.setUserId(UUID.randomUUID().toString());
		dummyUser.setPassword(passwordEncoder.encode(dummyUser.getPassword()));
		return dummyUserRepository.save(dummyUser);
	}
}
