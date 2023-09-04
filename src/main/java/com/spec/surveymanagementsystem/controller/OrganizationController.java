package com.spec.surveymanagementsystem.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.config.RestResponse;
import com.spec.surveymanagementsystem.dto.OrganizationDto;
import com.spec.surveymanagementsystem.model.*;
import com.spec.surveymanagementsystem.repository.OrganizationRepository;
import com.spec.surveymanagementsystem.service.OrganizationService;

import jakarta.validation.Valid;

/**
 * The organization controller.
 *
 * @author : SPEC Developer on 22/08/2023.
 */
@RestController
@RequestMapping("/api/v1")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	// private OrganizationRepository organizationRepository; 

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
	// This method use for create organization
	@PostMapping("/organization")
	@ResponseBody
	public ResponseEntity<RestResponse<Organization>> createOrganization(@Valid @RequestBody OrganizationDto organizationDto) {
		try {
			 // Save the organization
	        Organization savedOrganization = organizationService.createOrganization(organizationDto);

	        // Create a success response
	        RestResponse<Organization> response = new RestResponse<>();
	        response.setStatus(HttpStatus.CREATED.value());
	        response.setMessage("Organization created successfully");
	        response.setData(savedOrganization);

	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        // Handle exceptions
	        return (ResponseEntity<RestResponse<Organization>>) handleException(e);
	    }
	}

	//This method use for get all organization
	@GetMapping("/organizations")
	@ResponseBody
	public ResponseEntity<RestResponse<List<Organization>>> getAllOrganizations() {
	    try {
	        // Retrieve the list of organizations from the service
	        List<Organization> organizations = organizationService.getAllOrganizations();
	        
	        // Create a success response
	        RestResponse<List<Organization>> response = new RestResponse<>();
	        response.setStatus(HttpStatus.OK.value());
	        response.setMessage("Organizations retrieved successfully");
	        response.setData(organizations);

	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();
	        
	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<List<Organization>> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to retrieve organizations. Please try again later.");
	        
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	// This method use for get organization by id
	@GetMapping("/organization/{id}")
	@ResponseBody
	public ResponseEntity<RestResponse<Organization>> getOrganizationById(@PathVariable Long id) {
	    try {
	        // Attempt to find the organization by its ID
	        Optional<Organization> organization = organizationService.getOrganizationById(id);

	        // Check if the organization exists
	        if (organization.isPresent()) {
	            // Create a success response
	            RestResponse<Organization> response = new RestResponse<>();
	            response.setStatus(HttpStatus.OK.value());
	            response.setMessage("Organization retrieved successfully");
	            response.setData(organization.get()); // Extract the organization from Optional

	            // Return a success response with the organization and HTTP status 200 (OK)
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            // Return a 404 (Not Found) response with an error message
	            RestResponse<Organization> errorResponse = new RestResponse<>();
	            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	            errorResponse.setMessage("Organization with ID " + id + " not found.");
	            
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<Organization> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to retrieve organization. Please try again later.");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	// This method use for update organization
	@PutMapping("/organization/{id}")
	@ResponseBody
	public ResponseEntity<RestResponse<Organization>> updateOrganization(@PathVariable Long id, @Valid @RequestBody Organization updatedOrganization) {
	    try {
	        Optional<Organization> existingOrganizationOptional = organizationService.updateOrganization(id, updatedOrganization);

	        if (existingOrganizationOptional.isPresent()) {
	            Organization updated = existingOrganizationOptional.get();

	            // Create a success response
	            RestResponse<Organization> response = new RestResponse<>();
	            response.setStatus(HttpStatus.OK.value());
	            response.setMessage("Organization updated successfully");
	            response.setData(updated);

	            // Return a success response with the updated organization and HTTP status 200 (OK)
	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            // Return a 404 (Not Found) response with an error message
	            RestResponse<Organization> errorResponse = new RestResponse<>();
	            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	            errorResponse.setMessage("Organization not found.");

	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<Organization> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to update organization. Please try again later.");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}

	
	// This controller method to delete organization
	@DeleteMapping(value = "/organization/{id}")
	@ResponseBody
	public ResponseEntity<RestResponse<String>> deleteOrganization(@PathVariable Long id) {
	    try {
	        // Check if the organization with the given ID exists and delete it
	        boolean isDeleted = organizationService.deleteOrganization(id);

	        if (isDeleted) {
	            // Create a success response
	            RestResponse<String> response = new RestResponse<>();
	            response.setStatus(HttpStatus.OK.value());
	            response.setMessage("Organization with ID " + id + " has been deleted.");

	            return ResponseEntity.status(HttpStatus.OK).body(response);
	        } else {
	            // Return a 404 (Not Found) response with an error message
	            RestResponse<String> errorResponse = new RestResponse<>();
	            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	            errorResponse.setMessage("Organization with ID " + id + " not found.");

	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	        }
	    } catch (Exception e) {
	        // Log the exception
	        e.printStackTrace();

	        // Handle exceptions and return an error response with a meaningful error message
	        RestResponse<String> errorResponse = new RestResponse<>();
	        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        errorResponse.setMessage("Failed to delete organization. Please try again later.");

	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}

	// This method use for handle exceptiona
	private ResponseEntity<?> handleException(Exception e) {
	    // Log the exception
	    e.printStackTrace();

	    // Create an error response
	    RestResponse<?> response = new RestResponse<>();
	    response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    response.setMessage("An error occurred. Please try again later.");

	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}