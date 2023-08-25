package com.spec.surveymanagementsystem.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class SurveyDTO {

    @NotBlank
    private String title;

    private String descriptions;

    @NotNull
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @NotNull
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    @NotBlank
    private String surveyLink;

    @NotNull
    private Long organizationId;
    
    @NotNull
    private Long UserId;
    
    
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

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Long getUserId() {
		return UserId;
	}

	public void setUserId(Long userId) {
		UserId = userId;
	}



	
    // Getters and setters
    
}
