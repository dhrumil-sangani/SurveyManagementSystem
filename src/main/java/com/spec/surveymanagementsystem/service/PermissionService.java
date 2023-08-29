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

    public Permission createPermission(String name, boolean status) {
    	Permission role = new Permission();
        role.setName(name);
        role.setStatus(status);
        return permissionRepository.save(role);
    }
}
