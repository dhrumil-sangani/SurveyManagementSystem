package com.spec.surveymanagementsystem.service;
import java.util.List;
import java.util.Optional;

import com.spec.surveymanagementsystem.model.Organization;


/**
 * The organization interface.
 * @author : SPEC Developer on 23/08/2023.
 */
public interface OrganizationInterface {

	
	List<Organization> findAll();
	void save(Organization theOrganization);
	void update(Organization theOrganization);
	void deleteById(int theId);
	Optional<Organization> findById(Long theId);
	
}
