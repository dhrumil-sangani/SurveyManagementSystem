package com.spec.osm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	
	private long id;
	private long organizationId;
	
	@NotEmpty(message = "First name is required")
    @Size(max = 50, message = "First name must be at most 50 characters")
	private String firstName;
	
	@NotEmpty(message = "Last name is required")
	@Size(max = 50, message = "Last name must be at most 50 characters")
	private String lastName;
	
	@NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
	private String email;
	
	@NotEmpty(message = "Password is required")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
	private String password;
	
//	@Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number")
	private long contactNumber;
	
	private boolean status;
	
}
