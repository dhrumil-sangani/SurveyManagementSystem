package com.spec.surveymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User dummyuser = userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found ")); 
		return dummyuser;
	}

}
