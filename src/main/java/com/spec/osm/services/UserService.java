package com.spec.osm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spec.osm.entities.User;
import com.spec.osm.repositories.UserRepository;

@Service
public class UserService {
	
	private static List<User> usersList = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	// store user service
	public User storeUser(User users) {		
		return userRepository.save(users);
	}

}
