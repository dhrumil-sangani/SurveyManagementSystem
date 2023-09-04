package com.spec.surveymanagementsystem.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		
		response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        		
        response.getWriter().write("{\"status\": 401,\"message\": \"Invalid credentials\"}");

//        PrintWriter writer = response.getWriter();
//        writer.println("Access Deniedcc !! " + authException.getMessage());
	}
}
