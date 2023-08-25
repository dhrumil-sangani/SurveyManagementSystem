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

import com.spec.surveymanagementsystem.model.*;
import com.spec.surveymanagementsystem.repository.OrganizationRepository;
import com.spec.surveymanagementsystem.service.*;

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
	private OrganizationRepository organizationRepository;

	// This method use for create organization
	@PostMapping(value = "/organization")
	@ResponseBody
	public ResponseEntity<Object> getOrganization(@Valid @RequestBody Organization organization) {
		try {
			// Save the organization
			Organization savedOrganization = organizationRepository.save(organization);

			// Return a success response with the saved organization and HTTP status 201
			// (Created)
			return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganization);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return an error response with a meaningful error message and HTTP status 500
			// (Internal Server Error)
			String errorMessage = "Failed to create organization. Please check your input and try again.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	// This method use for get all organization
	@GetMapping(value = "/organization")
	@ResponseBody
	public ResponseEntity<Object> getAllOrganizations() {
		try {
			// Retrieve the list of organizations from the repository
			List<Organization> organizations = organizationRepository.findAll();

			// Return a success response with the list of organizations and HTTP status 200
			// (OK)
			return ResponseEntity.status(HttpStatus.OK).body(organizations);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return an error response with a meaningful error message and HTTP status 500
			// (Internal Server Error)
			String errorMessage = "Failed to retrieve organizations. Please try again later.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	// This method use for get organization by id
	@GetMapping(value = "/organization/{id}")
	@ResponseBody
	public ResponseEntity<Object> getOrganizationById(@PathVariable Long id) {
		try {
			// Attempt to find the organization by its ID
			Optional<Organization> organization = organizationRepository.findById(id);

			// Check if the organization exists
			if (organization.isPresent()) {
				// Return a success response with the organization and HTTP status 200 (OK)
				return ResponseEntity.status(HttpStatus.OK).body(organization.get());
			} else {
				// Return a 404 (Not Found) response with an error message
				String errorMessage = "Organization with ID " + id + " not found.";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
			}
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return an error response with a meaningful error message and HTTP status 500
			// (Internal Server Error)
			String errorMessage = "Failed to retrieve organization. Please try again later.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}

	// This method use for update organization
	@PutMapping(value = "/organization/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateOrganization(@PathVariable Long id,
			@Valid @RequestBody Organization updatedOrganization) {
		try {
			// Check if the organization with the given ID exists
			Optional<Organization> existingOrganizationOptional = organizationRepository.findById(id);

			if (existingOrganizationOptional.isPresent()) {
				// Get the existing organization
				Organization existingOrganization = existingOrganizationOptional.get();

				// Update the existing organization with the new data
				existingOrganization.setName(updatedOrganization.getName());
				existingOrganization.setDescription(updatedOrganization.getDescription());

				// Save the updated organization
				Organization updated = organizationRepository.save(existingOrganization);

				// Return a success response with the updated organization and HTTP status 200
				// (OK)
				return ResponseEntity.status(HttpStatus.OK).body(updated);
			} else {
				// Return a 404 (Not Found) response with an error message
				String errorMessage = "Organization with ID " + id + " not found.";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
			}
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return an error response with a meaningful error message and HTTP status 500
			// (Internal Server Error)
			String errorMessage = "Failed to update organization. Please try again later.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}
	
	// This method use for delete organization
	@DeleteMapping(value = "/organization/{id}")
	@ResponseBody
	public ResponseEntity<Object> deleteOrganization(@PathVariable Long id) {
		try {
			// Check if the organization with the given ID exists
			Optional<Organization> organizationOptional = organizationRepository.findById(id);

			if (organizationOptional.isPresent()) {
				// If the organization exists, delete it
				organizationRepository.deleteById(id);

				// Return a success response with a message and HTTP status 204 (No Content)
				String successMessage = "Organization with ID " + id + " has been deleted.";
				return ResponseEntity.status(HttpStatus.OK).body(successMessage);
			} else {
				// Return a 404 (Not Found) response with an error message
				String errorMessage = "Organization with ID " + id + " not found.";
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
			}
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return an error response with a meaningful error message and HTTP status 500
			// (Internal Server Error)
			String errorMessage = "Failed to delete organization. Please try again later.";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}

	}
}