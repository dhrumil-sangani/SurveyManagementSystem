package com.spec.osm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.osm.dto.UserDTO;
import com.spec.osm.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/store-user")
	public ResponseEntity<UserDTO> storeUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO storeUser = userService.storeUser(userDto);
		return new ResponseEntity<>(storeUser, HttpStatus.CREATED);
	}
}
