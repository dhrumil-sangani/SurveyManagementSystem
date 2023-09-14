package com.spec.surveymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.config.RestResponse;
import com.spec.surveymanagementsystem.model.CustomResponse;
import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.model.JwtRequest;
import com.spec.surveymanagementsystem.model.JwtResponse;
import com.spec.surveymanagementsystem.repository.UserRepository;
import com.spec.surveymanagementsystem.security.JwtHelper;
import com.spec.surveymanagementsystem.service.UserService;

import jakarta.validation.Valid;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
public class AuthController {
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private UserService userService; 
    
    @Autowired
    private UserRepository userRepository;
    
	@Autowired
	private PasswordEncoder passwordEncoder; 
    
    @Autowired
    private JwtHelper helper;

    @PostMapping("/auth/login")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_JSON })
    public ResponseEntity<CustomResponse> login(@RequestBody JwtRequest request) {
    	
        this.doAuthenticate(request.getEmail(), request.getPassword()); 

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        
        CustomResponse response = new CustomResponse();
        response.setStatus(200);
        response.setMessage("Login Successfully");
        response.setData(new JwtResponse(token,userDetails));
        
        return ResponseEntity.ok(response); 
         
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
   	 
        try {
            manager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password !!");
        }
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<CustomResponse> exceptionHandler() {
    	CustomResponse response = new CustomResponse();
        response.setStatus(401);
        response.setMessage("Credentials Invalid !!");
        return ResponseEntity.ok(response); 
    }
    
    @PostMapping("api/v1/change-password")
    public ResponseEntity<RestResponse<Object>> changePassword(@Valid @RequestBody Map<String, Object> requestBody,Principal principal) {
    	try {
	    	String oldPassword  = (String) requestBody.get("currentPassword");
	    	String newPassword  = (String) requestBody.get("newPassword");
	    	String confirnNewPassword  = (String) requestBody.get("confirmNewPassword");
	    	
	    	boolean checkPassword = newPassword.equals(confirnNewPassword);
	    		    	
	    	if(checkPassword) {
	    		
	    		User user = userRepository.findByEmail(principal.getName()).orElseThrow(()-> new RuntimeException("User Not Found ")); 
	    		
	    		boolean passwordMatches = passwordEncoder.matches(oldPassword, user.getPassword());
	    		
	    		if (passwordMatches) {
	    			user.setPassword(passwordEncoder.encode(newPassword));
	    			userRepository.save(user);
	    			
	    			// Create a success response
	    			RestResponse<Object> response = new RestResponse<>();
	    			response.setStatus(HttpStatus.OK.value());
	    			response.setMessage("Password changed successfully");
	    			response.setData(null);
	    			
	    			// Return a success response with the updated user and HTTP status 200 (OK)
	    			return ResponseEntity.status(HttpStatus.OK).body(response);
	    		} else {
	    			RestResponse<Object> errorResponse = new RestResponse<>();
	    			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	    			errorResponse.setMessage("Invalid Current password");
	    			
	    			return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
	    		}
	    	} else {
	    		RestResponse<Object> errorResponse = new RestResponse<>();
    			errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    			errorResponse.setMessage("New Password ans Confirm new Password must be same");
    			
    			return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
	    	}
	
    	} catch (Exception e) {
    		// Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<Object> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to Change Password");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    	}
    }
 
}
