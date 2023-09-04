//package com.spec.surveymanagementsystem.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.spec.surveymanagementsystem.service.UserService;
//import com.spec.surveymanagementsystem.model.DummyUser;
//
//import java.security.Principal;
//import java.util.*;
//
//@RestController
//@RequestMapping("/api/v1")
//public class HomeController {
//
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping("/user")
//	public List<DummyUser> getUser() {
//		return userService.getUser();
//	}
//	
//	@GetMapping("/current-user")
//	public String getLoggedinUser(Principal principal) {
//		return principal.getName();
//	}
//}
