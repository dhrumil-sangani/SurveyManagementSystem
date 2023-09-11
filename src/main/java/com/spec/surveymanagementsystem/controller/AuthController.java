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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.model.CustomResponse;
import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.model.JwtRequest;
import com.spec.surveymanagementsystem.model.JwtResponse;
import com.spec.surveymanagementsystem.repository.UserRepository;
import com.spec.surveymanagementsystem.security.JwtHelper;
import com.spec.surveymanagementsystem.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
    private UserService userService; 

    @Autowired
    private JwtHelper helper;

    @PostMapping("/login")
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
    
//    @Produces(MediaType.APPLICATION_JSON)
//	@Consumes({ MediaType.APPLICATION_JSON })
//    @PostMapping("/create-user")
//    public DummyUser createUser(@RequestBody DummyUser dummyUser) {
//    	return userService.createUser(dummyUser);
//    }
}
