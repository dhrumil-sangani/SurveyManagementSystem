package com.spec.surveymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.spec.surveymanagementsystem.model.Organization;
import com.spec.surveymanagementsystem.repository.OrganizationRepository;


/**
 * The organization services.
 *
 * @author : SPEC Developer on 23/08/2023.
 */
@Service
public class OrganizationService implements OrganizationInterface{
	private OrganizationRepository organizationRepository;
	@Override
	public List<Organization> findAll() {
		return organizationRepository.findAll();
	}

	@Override
	public Optional<Organization> findById(Long theId) {
		return organizationRepository.findById(theId);
	}

	@Override
	public void save(Organization theOrganization) {
		organizationRepository.save(theOrganization);
	}

	@Override
	public void update(Organization theOrganization) {
		
		
	}

	@Override
	public void deleteById(int theId) {
		
		
	}

	
	
	
}
