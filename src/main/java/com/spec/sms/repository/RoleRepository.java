package com.spec.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.sms.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
