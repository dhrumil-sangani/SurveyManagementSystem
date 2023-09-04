package com.spec.surveymanagementsystem.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.model.CustomListResponse;
import com.spec.surveymanagementsystem.model.DummyUser;
import com.spec.surveymanagementsystem.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<CustomListResponse> getUser() {
		List<DummyUser> users =  userService.getUser();
		CustomListResponse response = new CustomListResponse();
        response.setStatus(200);
        response.setMessage("User Fetch Successfully");
        response.setData(users);
        return ResponseEntity.ok(response);
	}
	
	@GetMapping("/current-user")
	public String getLoggedinUser(Principal principal) {
		return principal.getName();
	}

}