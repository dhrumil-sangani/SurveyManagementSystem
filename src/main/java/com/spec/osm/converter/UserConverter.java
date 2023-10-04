package com.spec.osm.converter;

import com.spec.osm.dto.UserDTO;
import com.spec.osm.entities.Organization;
import com.spec.osm.entities.User;

public class UserConverter {

	// Convert User JPA Entity into UserDto
	public static UserDTO mapToUserDto(User user) {
		UserDTO userDto = new UserDTO();
		
		userDto.setOrganizationId(user.getOrganization().getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setContactNumber(user.getContactNumber());
		userDto.setStatus(user.isStatus());
		
		return userDto;
	}

	// Convert UserDto into User JPA Entity
	public static User mapToUser(UserDTO userDto) {
		User user = new User();

		Organization organization = new Organization();
		organization.setId(userDto.getOrganizationId());
		user.setOrganization(organization);

		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setContactNumber(userDto.getContactNumber());
		user.setStatus(userDto.isStatus());

		return user;
	}
}
