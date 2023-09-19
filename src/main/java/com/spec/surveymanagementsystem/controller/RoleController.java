package com.spec.surveymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spec.surveymanagementsystem.dto.RoleDto;
import com.spec.surveymanagementsystem.model.Role;
import com.spec.surveymanagementsystem.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

	@Autowired
	private final RoleService roleService;


	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PostMapping("/create-role")
	public Role createRole(@Valid @RequestBody RoleDto request) {
		return roleService.createRole(request.getName(), request.getStatus());
	}
}
