package com.spec.surveymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.model.Role;
import com.spec.surveymanagementsystem.repository.RoleRepository;

@Service
public class RoleService {
	private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role createRole(String roleName, String status) {
        Role role = new Role();
        role.setName(roleName);
        role.setStatus(status);
        return roleRepository.save(role);
    }
}
