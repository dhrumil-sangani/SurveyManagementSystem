package com.spec.osm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.osm.converter.UserConverter;
import com.spec.osm.dto.UserDTO;
import com.spec.osm.entities.User;
import com.spec.osm.exceptions.EmailAlreadyExistsException;
import com.spec.osm.repositories.UserRepository;

@Service
public class UserService {
	
//	private static List<User> usersList = new ArrayList<User>();
	
	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
	
	// store user service
	public UserDTO storeUser(UserDTO userDto) {
		
		if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
		
		// Convert UserDto into User JPA Entity
		User user = UserConverter.mapToUser(userDto);
		User storeUser = userRepository.save(user);
		
		// Convert User JPA entity to UserDto
        UserDTO storeUserDto = UserConverter.mapToUserDto(storeUser);
		
        return storeUserDto; 
	}

}
