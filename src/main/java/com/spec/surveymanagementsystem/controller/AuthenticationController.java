package com.spec.surveymanagementsystem.controller;

import java.util.*;
import com.spec.surveymanagementsystem.model.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AuthenticationController {

	@GetMapping("/user")
	public String hello() {
		return "Hello";
	}
}
