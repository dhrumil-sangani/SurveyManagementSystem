package com.spec.osm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "organization_id", nullable = true) private Organization
	 * organizationId;
	 */

	@Column(name = "fist_name", length = 50, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(length = 255, nullable = false)
	private String password;

	@Column(name = "contact_numbner", length = 15, nullable = false)
	private int contactNumber;

	@Column(columnDefinition = "boolean default false COMMENT '0 = Inactive, 1 = Active'", nullable = false)
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
