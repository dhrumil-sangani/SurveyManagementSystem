package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.osm.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	Organization findByName(String name);
}
