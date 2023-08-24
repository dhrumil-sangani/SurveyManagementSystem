package com.spec.surveymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.Permission;
import com.spec.surveymanagementsystem.repository.PermissionRepository;

@Service
public class PermissionService {
	private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Permission createPermission(String permissionName, String status) {
        Permission permission = new Permission();
        permission.setName(permissionName);
        permission.setStatus(status);
        return permissionRepository.save(permission);
    }
}
