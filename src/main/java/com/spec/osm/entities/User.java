package com.spec.osm.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	
	@ManyToOne
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organizationId;
	
	@Column(name = "fist_name", length = 50, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(length = 255, nullable = false, unique = true)
	private String password;

	@Column(columnDefinition = "DEFAULT '1' COMMENT '0 = Inactive, 1 = Active'", nullable = false)
    private boolean status;
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private int createdAt;

	@JoinColumn(name = "created_by", referencedColumnName = "id")
    private Long createdBy;

	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private Timestamp updatedAt;

	@JoinColumn(name = "updated_by", referencedColumnName = "id")
    private Long updatedBy;
	
	
}
