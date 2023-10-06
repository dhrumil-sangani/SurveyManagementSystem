package com.spec.osm.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.osm.converter.OrganizationConverter;
import com.spec.osm.dto.OrganizationDTO;
import com.spec.osm.entities.Organization;
import com.spec.osm.exceptions.EmailAlreadyExistsException;
import com.spec.osm.repositories.OrganizationRepository;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository; 
	
	public List<OrganizationDTO> getOrganization () {
		
		List<Organization> organization =  organizationRepository.findAll();
		
		return organization.stream()
                .map(OrganizationConverter::mapToOrganizationDto)
                .collect(Collectors.toList());
		
	}
	
	public OrganizationDTO getOrganizationById (Long id) {
		Optional<Organization> organizationOptional = organizationRepository.findById(id);
		
		if(organizationOptional.isPresent()) {
			Organization organization = organizationOptional.get();
			return OrganizationConverter.mapToOrganizationDto(organization);
		} else {
			return null;
		}
	}

	public OrganizationDTO createOrganization (OrganizationDTO organizationDTO) {
		
		if (organizationRepository.findByName(organizationDTO.getName()) != null) {
            throw new EmailAlreadyExistsException("Organization Name already exists");
        }
		
		// Convert OrgnizationDto into Organization JPA Entity
		Organization organization = OrganizationConverter.mapToOrganization(organizationDTO);
		Organization storeOrganization = organizationRepository.save(organization);
		
		// Convert Organization JPA entity to OrgnizationDto
		OrganizationDTO storeOrganizationDto = OrganizationConverter.mapToOrganizationDto(storeOrganization);
		
		return storeOrganizationDto;
	}
	
	public boolean updateOrganization (OrganizationDTO organizationDTO) {
		
        Long organizationId = organizationDTO.getId();

		Optional<Organization> existingOrganizationOptional = organizationRepository.findById(organizationId);

        if (existingOrganizationOptional.isPresent()) {
        	Organization OrganizationToUpdate = existingOrganizationOptional.get();
        	
        	OrganizationToUpdate.setName(organizationDTO.getName());
        	OrganizationToUpdate.setDescription(organizationDTO.getDescription());
        	OrganizationToUpdate.setStatus(organizationDTO.isStatus());
           
        	organizationRepository.save(OrganizationToUpdate);
        	
        	return true;
        	
        } else {
            return false; // Indicate that the organization was not found
        }
	}
	
	public boolean deleteOrganizationById (Long id) {
		Optional<Organization> organizationOptional = organizationRepository.findById(id);

        if (organizationOptional.isPresent()) {
            organizationRepository.deleteById(id);
            return true;
        } else {
            return false; // Indicate that the organization was not found
        }
	}
}
