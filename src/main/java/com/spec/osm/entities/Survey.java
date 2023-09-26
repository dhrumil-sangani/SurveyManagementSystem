package com.spec.osm.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "surveys")
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	private Organization organization;

	@ManyToOne
	@JoinColumn(name = "created_by", referencedColumnName = "id", nullable = true)
	private User createdByUser;

	@ManyToOne
	@JoinColumn(name = "updated_by", referencedColumnName = "id", nullable = true)
	private User updatedByUser;

	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Question> questions = new ArrayList<>();

	@Column(name = "title", length = 50, nullable = false)
	private String title;

	@Column(name = "descriptions", length = 500, columnDefinition = "text")
	private String descriptions;

	@Column(name = "start_date", nullable = false, columnDefinition = "DATE")
	private Date startDate;

	@Column(name = "expiration_date", nullable = false, columnDefinition = "DATE")
	private Date expirationDate;

	@Column(name = "survey_link", nullable = false)
	private String surveyLink;

	@Column(name = "status", nullable = false)
	private boolean status;

	@CreationTimestamp
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

}