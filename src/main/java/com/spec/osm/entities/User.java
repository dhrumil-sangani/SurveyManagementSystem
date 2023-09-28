package com.spec.osm.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id", nullable = true)
	private Organization organization;

	@NotBlank(message = "First name is required")
	@Size(max = 50, message = "First name must be at most 50 characters")
	@Column(name = "fist_name", length = 50, nullable = false)
	private String firstName;

	@NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be at most 50 characters")
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be 8 characters")
	@Column(length = 255, nullable = false)
	private String password;

	@Pattern(regexp = "\\d{10}", message = "Contact number must be a 10-digit number")
	@Column(name = "contact_number", length = 15, nullable = false)
	private long contactNumber;

	@Column(columnDefinition = "boolean default true COMMENT '0 = Inactive, 1 = Active'", nullable = false)
	private boolean status;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	/*
	 * @JoinColumn(name = "created_by", referencedColumnName = "id") private User
	 * createdBy;
	 * 
	 * @JoinColumn(name = "updated_by", referencedColumnName = "id") private User
	 * updatedBy;
	 */

}
