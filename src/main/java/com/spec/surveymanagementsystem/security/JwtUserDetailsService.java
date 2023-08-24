package com.spec.surveymanagementsystem.security;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.exception.UserNotFoundException;
import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(), user.getPassword(), new ArrayList<>()
        );
    }
}
