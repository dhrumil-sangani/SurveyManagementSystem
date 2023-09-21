package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.osm.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
