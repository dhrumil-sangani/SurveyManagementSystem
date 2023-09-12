package com.spec.surveymanagementsystem.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.config.RestResponse;
import com.spec.surveymanagementsystem.dto.OrganizationDto;
import com.spec.surveymanagementsystem.model.CustomListResponse;
import com.spec.surveymanagementsystem.model.User;

import com.spec.surveymanagementsystem.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/current-user")
	public String getLoggedinUser(Principal principal) {
		return principal.getName();
	}
	
	// This method use for create user
	@PostMapping("/create-user")
	@ResponseBody
	public ResponseEntity<RestResponse<User>> createUser(@Valid @RequestBody User userDto) {
		try {
			 // Save the user
			User savedUser = userService.createUser(userDto); 

	        // Create a success response
	        RestResponse<User> response = new RestResponse<>();
	        response.setStatus(HttpStatus.OK.value());
	        response.setMessage("User created successfully");
	        response.setData(savedUser);

	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } catch (Exception e) {
	        // Handle exceptions
	        return (ResponseEntity<RestResponse<User>>) handleException(e);
	    }
	}
	
	//This method use for get all users
	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity<RestResponse<List<User>>> getAllUsers() {
	    try {
	        // Retrieve the list of Users from the service
	        List<User> users = userService.getAllUsers();
	        
	        // Create a success response
	        RestResponse<List<User>> response = new RestResponse<>();
	        response.setStatus(HttpStatus.OK.value());
	        response.setMessage("Users retrieved successfully");
	        response.setData(users);

	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	        
	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<List<User>> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to retrieve Users. Please try again later.");
	        
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
		
	// This method use for update user
	@PutMapping("/user/{id}")
	@ResponseBody
	public ResponseEntity<RestResponse<User>> updateUsers(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
	    try {
	        Optional<User> existingUserOptional = userService.updateUser(id, updatedUser);

	        if (existingUserOptional.isPresent()) {
	        	User updated = existingUserOptional.get();

	            // Create a success response
	            RestResponse<User> response = new RestResponse<>();
	            response.setStatus(HttpStatus.OK.value());
	            response.setMessage("User updated successfully");
	            response.setData(updated);

	            // Return a success response with the updated user and HTTP status 200 (OK)
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            // Return a 404 (Not Found) response with an error message
	            RestResponse<User> errorResponse = new RestResponse<>();
	            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	            errorResponse.setMessage("User not found.");

	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<User> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to update user. Please try again later.");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	
	// This controller method to delete user
	@DeleteMapping(value = "/user/{id}")
	@ResponseBody
	public ResponseEntity<RestResponse<String>> deleteUser(@PathVariable Long id) {
	    try {
	        // Check if the user with the given ID exists and delete it
	        boolean isDeleted = userService.deleteUser(id);

	        if (isDeleted) {
	            // Create a success response
	            RestResponse<String> response = new RestResponse<>();
	            response.setStatus(HttpStatus.OK.value());
	            response.setMessage("User has been deleted.");

	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            // Return a 404 (Not Found) response with an error message
	            RestResponse<String> errorResponse = new RestResponse<>();
	            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	            errorResponse.setMessage("user not found.");

	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<String> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to delete user. Please try again later.");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	
	private ResponseEntity<?> handleException(Exception e) {
	    // Log the exception
	    e.printStackTrace();

	    // Create an error response
	    RestResponse<?> response = new RestResponse<>();
	    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    response.setMessage("An error occurred. Please try again later.");

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

}