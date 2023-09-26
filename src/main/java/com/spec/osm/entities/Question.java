package com.spec.osm.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "survey_id", nullable = false)
	private Survey survey;

	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false, length = 100)
	private QuestionType type;

	@Column(name = "is_required", nullable = false)
	private boolean isRequired;

	@Column(name = "status", nullable = false)
	private boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
	private User createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "updated_by", referencedColumnName = "id")
	private User updatedBy;


	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = new Date();
	}

	public enum QuestionType {
		RADIO, CHECKBOX, INPUT, DROPDOWN
	}
	
	// Constructors, getters, and setters

	// Getters and setters for all fields

	// Add constructors as needed

	// Other methods as needed
}
