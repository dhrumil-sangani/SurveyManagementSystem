package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spec.surveymanagementsystem.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
