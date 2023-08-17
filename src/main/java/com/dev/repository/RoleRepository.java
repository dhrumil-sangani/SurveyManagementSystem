package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
