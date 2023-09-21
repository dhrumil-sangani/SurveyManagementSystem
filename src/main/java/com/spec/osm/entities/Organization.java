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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 400, nullable = false)
	private String description;

	@Column(columnDefinition = "DEFAULT '1' COMMENT '0 = Inactive, 1 = Active'", nullable = false)
	private boolean status;

	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private Date createdAt;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@Column(name = "updated_at", columnDefinition = "TIMESTAMP")
	private Date updatedAt;

	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;
	
}
