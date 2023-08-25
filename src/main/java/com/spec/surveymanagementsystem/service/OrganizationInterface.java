package com.spec.surveymanagementsystem.service;
import java.util.List;
import java.util.Optional;

import com.spec.surveymanagementsystem.dto.OrganizationDto;
import com.spec.surveymanagementsystem.model.Organization;


/**
 * The organization interface.
 * @author : SPEC Developer on 23/08/2023.
 */
public interface OrganizationInterface {
	 List<Organization> getAllOrganizations();
	 Organization createOrganization(OrganizationDto organization);
	 Optional<Organization> updateOrganization(Long id, Organization updatedOrganization);
	 boolean deleteOrganization(Long id);
	 Optional<Organization> getOrganizationById(Long id);
	
}
