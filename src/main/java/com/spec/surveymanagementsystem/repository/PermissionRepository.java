package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.surveymanagementsystem.model.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
