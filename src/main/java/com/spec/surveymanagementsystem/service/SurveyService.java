package com.spec.surveymanagementsystem.service;

import com.spec.surveymanagementsystem.dto.SurveyDTO;
import com.spec.surveymanagementsystem.exception.ResourceNotFoundException;
import com.spec.surveymanagementsystem.model.Organization;
import com.spec.surveymanagementsystem.model.Survey;
import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.repository.OrganizationRepository;
import com.spec.surveymanagementsystem.repository.SurveyRepository;
import com.spec.surveymanagementsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private UserRepository UserRepository;

	public Survey createSurvey(SurveyDTO surveyDTO) throws ResourceNotFoundException {
		Organization organization = organizationRepository.findById(surveyDTO.getOrganizationId())
				.orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

		User createdByUser = UserRepository.findById(surveyDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		Survey survey = new Survey();
		survey.setCreatedByUser(createdByUser);
		survey.setTitle(surveyDTO.getTitle());
		survey.setDescriptions(surveyDTO.getDescriptions());
		survey.setStartDate(surveyDTO.getStartDate());
		survey.setExpirationDate(surveyDTO.getExpirationDate());
		survey.setSurveyLink(surveyDTO.getSurveyLink());
		survey.setOrganization(organization);

		return surveyRepository.save(survey);
	}

	public List<Survey> listSurveys() {
		return surveyRepository.findAll();
	}

	public Survey updateSurvey(Long surveyId, SurveyDTO surveyDTO) {

		Survey survey = surveyRepository.findById(surveyId)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
		User updatedByUser = UserRepository.findById(surveyDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		survey.setUpdatedByUser(updatedByUser);
		survey.setTitle(surveyDTO.getTitle());
		survey.setDescriptions(surveyDTO.getDescriptions());
		survey.setStartDate(surveyDTO.getStartDate());
		survey.setExpirationDate(surveyDTO.getExpirationDate());
		survey.setSurveyLink(surveyDTO.getSurveyLink());

		return surveyRepository.save(survey);
	}

	public void deleteSurvey(Long surveyId) {
		if (!surveyRepository.existsById(surveyId)) {
			throw new ResourceNotFoundException("Survey not found");
		}
		surveyRepository.deleteById(surveyId);
	}

	public Survey getSurveyById(Long surveyId) {
		return surveyRepository.findById(surveyId).orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
	}
}
