package com.spec.surveymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.dto.PermissionCreateRequest;
import com.spec.surveymanagementsystem.model.Permission;
import com.spec.surveymanagementsystem.service.PermissionService;

@RestController
@RequestMapping("/api/v1")
public class PermissionController {
	private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping("/permissions")
    public Permission createPermission(@RequestBody PermissionCreateRequest request) {
        return permissionService.createPermission(request.getPermissionName(), request.getStatus());
    }
}
