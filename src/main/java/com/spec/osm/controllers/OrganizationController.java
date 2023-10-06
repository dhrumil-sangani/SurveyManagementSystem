package com.spec.osm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.osm.dto.OrganizationDTO;
import com.spec.osm.entities.CustomResponse;
import com.spec.osm.services.OrganizationService;

@RestController
@RequestMapping("/api/v1")
public class OrganizationController {
	
	private final OrganizationService organizationService;
	
	public OrganizationController(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}
	
	//This service is used for Create Organization
	@PostMapping("/organization")
	public ResponseEntity<CustomResponse<OrganizationDTO>> createOrganization(@Valid @RequestBody OrganizationDTO organizationDTO, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
	        CustomResponse<OrganizationDTO> response = new CustomResponse<>(HttpStatus.BAD_REQUEST.value(), "Validation failed", null);
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	    }
		
		OrganizationDTO storeOrganization = organizationService.createOrganization(organizationDTO);
				
		CustomResponse<OrganizationDTO> response = new CustomResponse<>(HttpStatus.CREATED.value(), "User has been added",storeOrganization);		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	//This service is used for Get All Organization
	@GetMapping("/organization")
	public ResponseEntity<CustomResponse<List<OrganizationDTO>>> getOrganization () {
		List<OrganizationDTO> organizations = organizationService.getOrganization();
		CustomResponse<List<OrganizationDTO>> response = new CustomResponse<>(HttpStatus.OK.value(), "Success", organizations);
		
        return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	//This service is used for Get Organization based on Id
	@GetMapping("/organization/{id}")
	public ResponseEntity<CustomResponse<OrganizationDTO>> getOrganizationById(@PathVariable Long id) {
		OrganizationDTO organizationDTO = organizationService.getOrganizationById(id);
		
		if (organizationDTO != null) {
	        CustomResponse<OrganizationDTO> response = new CustomResponse<>(HttpStatus.OK.value(), "Organization found", organizationDTO);
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } else {
	        CustomResponse<OrganizationDTO> response = new CustomResponse<>(HttpStatus.NOT_FOUND.value(), "Organization not found", null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }
	}
	
	//This service used for Delete Organization based on Id
	@DeleteMapping("/organization/{id}")
	public ResponseEntity<CustomResponse<String>> deleteOrganization(@PathVariable Long id) {
		 
		boolean deleted = organizationService.deleteOrganizationById(id);
		
        if (deleted) {
        	CustomResponse<String> response = new CustomResponse<>(HttpStatus.NO_CONTENT.value(), "Organization has been deleted", null);
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } else {
        	CustomResponse<String> response = new CustomResponse<>(HttpStatus.NOT_FOUND.value(), "Organization not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
	}
	
	//This service user for Update Organization
	@PutMapping("organization/{id}")
	public ResponseEntity<CustomResponse<String>> updateOrganization(@PathVariable Long id, @Valid @RequestBody OrganizationDTO organizationDTO) {
		
		organizationDTO.setId(id); // Set the user's ID from the path variable
        boolean updated = organizationService.updateOrganization(organizationDTO);

        if (updated) {
            CustomResponse<String> response = new CustomResponse<>(HttpStatus.OK.value(), "Organization has been updated", null);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
        	CustomResponse<String> response = new CustomResponse<>(HttpStatus.NOT_FOUND.value(), "Organization not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
	}
}
