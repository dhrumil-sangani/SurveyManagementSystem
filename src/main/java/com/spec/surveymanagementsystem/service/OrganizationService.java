package com.spec.surveymanagementsystem.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.surveymanagementsystem.dto.OrganizationDto;
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
	@Autowired
    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }
   // This service method use for create organization
    public Organization createOrganization(OrganizationDto organizationDto) {
        // Add your business logic here, if needed
    	Organization organization = new Organization();
    	organization.setName(organizationDto.getName());
    	organization.setDescription(organizationDto.getDescription());
    	organization.setStatus(organizationDto.getStatus());
    	Date date = new Date();  
    	Timestamp ts=new Timestamp(date.getTime());  
    	organization.setCreatedAt(ts);
        return organizationRepository.save(organization);
    }
    /**
	 * @author Spec developer
	 * This method use for get all organizations
	 */
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    public Optional<Organization> getOrganizationById(Long id) {
        return organizationRepository.findById(id);
    }
//    This service method use for update organization
    public Optional<Organization> updateOrganization(Long id, Organization updatedOrganization) {
        Optional<Organization> existingOrganizationOptional = organizationRepository.findById(id);

        if (existingOrganizationOptional.isPresent()) {
            Organization existingOrganization = existingOrganizationOptional.get();
            existingOrganization.setName(updatedOrganization.getName());
            existingOrganization.setDescription(updatedOrganization.getDescription());
            Date date = new Date();  
        	Timestamp ts=new Timestamp(date.getTime());  
        	existingOrganization.setUpdatedAt(ts);
            return Optional.of(organizationRepository.save(existingOrganization));
        } else {
            return Optional.empty(); // Indicate that the organization was not found
        }
    }
    //  This service method use for delete organization
    public boolean deleteOrganization(Long id) {
        Optional<Organization> organizationOptional = organizationRepository.findById(id);

        if (organizationOptional.isPresent()) {
            organizationRepository.deleteById(id);
            return true;
        } else {
            return false; // Indicate that the organization was not found
        }
    }
	
}
