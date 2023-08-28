package com.spec.surveymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spec.surveymanagementsystem.dto.RoleCreateRequest;
import com.spec.surveymanagementsystem.model.Role;
import com.spec.surveymanagementsystem.service.RoleService;

@RestController
@RequestMapping("/api/v1")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/roles")
    public Role createRole(@RequestBody RoleCreateRequest request) {
        return roleService.createRole(request.getRoleName(), request.getStatus());
    }
}

