package com.spec.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.sms.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}