package com.spec.osm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.osm.JwtUtil;
import com.spec.osm.entities.AuthenticationRequest;
import com.spec.osm.entities.AuthenticationResponse;
import com.spec.osm.entities.User;
import com.spec.osm.repositories.UserRepository;

@RestController
public class AuthenticationController {
	
    @Autowired(required=true)
    private JwtUtil jwtUtil;
    
    @Autowired 
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        // If authentication is successful, generate a token.
    	if (authenticate(authenticationRequest)) {
            final String token = jwtUtil.generateToken(authenticationRequest.getEmail());
            return ResponseEntity.ok(new AuthenticationResponse(token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
    
    private boolean authenticate(AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();
        
        User user = userRepository.findByEmail(email);

        return user != null && user.getPassword().equals(password);
    }
}
