package com.spec.osm.converter;

import com.spec.osm.dto.OrganizationDTO;
import com.spec.osm.entities.Organization;

public class OrganizationConverter {
	
	// Convert Organization JPA Entity into OrganizationDto
	public static OrganizationDTO mapToOrganizationDto(Organization organization) {
		OrganizationDTO organizationDTO = new OrganizationDTO();
		
		organizationDTO.setId(organization.getId());
		organizationDTO.setName(organization.getName());
		organizationDTO.setDescription(organization.getDescription());
		organizationDTO.setStatus(organization.isStatus());
		
		return organizationDTO;
	}

	// Convert OrganizationDto into Organization JPA Entity
	public static Organization mapToOrganization(OrganizationDTO organizationDTO) {

		Organization organization = new Organization();

		organization.setId(organizationDTO.getId());
		organization.setName(organizationDTO.getName());
		organization.setDescription(organizationDTO.getDescription());
		organization.setStatus(organizationDTO.isStatus());

		return organization;
	}
}
