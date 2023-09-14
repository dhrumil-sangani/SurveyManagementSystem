package com.spec.surveymanagementsystem.service;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.repository.UserRepository;

@Service
public class UserService {
	private List<User> store = new ArrayList<>();
	 
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 

    /**
	 * @author Spec developer
	 * This method use for get all user
	 */
    public List<User> getAllUsers() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String loggedInUsername = authentication.getName();
    	
        List<User> allUsers = userRepository.findAll();
        
        List<User> usersExceptLoggedIn = allUsers.stream()
        	    .filter(user -> !user.getUsername().equals(loggedInUsername))
        	    .collect(Collectors.toList());
        
        return usersExceptLoggedIn;
    }
	
    //  This service method use for create User
	public User createUser(User User) {
		
		User.setPassword(passwordEncoder.encode(User.getPassword()));
		User.setStatus(User.getStatus());
		Date date = new Date();  
		Timestamp ts=new Timestamp(date.getTime());  
		User.setCreatedAt(ts);
		
		return userRepository.save(User);
	}

	//  This service method use for update User
	public Optional<User> updateUser(Long id, User updatedUser) {
	      Optional<User> existingUserOptional = userRepository.findById(id);
	
	      if (existingUserOptional.isPresent()) {
	    	  User existingUser = existingUserOptional.get();
	    	  
	    	  existingUser.setName(updatedUser.getName());
	    	  existingUser.setEmail(updatedUser.getEmail());
	    	  existingUser.setMobileNumber(updatedUser.getMobileNumber());
	    	  
	    	  Date date = new Date();  
	    	  Timestamp ts=new Timestamp(date.getTime());  
	    	  existingUser.setUpdatedAt(ts);
	    	  
	          return Optional.of(userRepository.save(existingUser));
	      } else {
	          return Optional.empty(); // Indicate that the user was not found
	      }
	}
	
	//  This service method use for delete user
    public boolean deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
        	userRepository.deleteById(id);
            return true;
        } else {
            return false; // Indicate that the user was not found
        }
    }
}
