package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spec.surveymanagementsystem.model.Role;
import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
	Optional<Role> findById(Role roleId);
}
