package com.spec.osm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class OrganizationDTO {
	private long id;
	
	@NotEmpty(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters")
	private String name;
	
	@NotEmpty(message = "Description is required")
	@Size(max = 50, message = "Description must be at most 50 characters")
	private String description;
	
	private boolean status;
}
