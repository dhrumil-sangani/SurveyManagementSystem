package com.spec.surveymanagementsystem.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "descriptions", columnDefinition = "text")
	private String descriptions;

	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "expiration_date", nullable = false)
	private Date expirationDate;

	@Column(name = "survey_link", nullable = false)
	private String surveyLink;

	@Column(name = "status", nullable = false)
	private boolean status;

	@CreationTimestamp
	@Column(name = "created_at")
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSurveyLink() {
		return surveyLink;
	}

	public void setSurveyLink(String surveyLink) {
		this.surveyLink = surveyLink;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}


	public User getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(User updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructors, getters, setters

}
