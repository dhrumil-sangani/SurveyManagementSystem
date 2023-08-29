package com.spec.surveymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.dto.PermissionDto;
import com.spec.surveymanagementsystem.model.Permission;
import com.spec.surveymanagementsystem.service.PermissionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class PermissionController {
	private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("/create-permission")
    public Permission createPermission(@Valid @RequestBody PermissionDto request) {
        return permissionService.createPermission(request.getName(), request.getStatus());
    }
}
