package com.spec.surveymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.DummyUser;
import com.spec.surveymanagementsystem.repository.DummyUserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private DummyUserRepository dummyUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		DummyUser dummyuser = dummyUserRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found ")); 
		return dummyuser;
	}

}
