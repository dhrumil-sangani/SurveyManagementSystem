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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organizations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 400, nullable = false)
	private String description;

	@Column(columnDefinition = "boolean default true COMMENT '0 = Inactive, 1 = Active'", nullable = false)
	private boolean status;

	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by", referencedColumnName = "id", nullable = true)
	private User createdBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = true)
	private User updatedBy;
	
	@OneToOne(mappedBy = "organization", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	private User user;
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
}
