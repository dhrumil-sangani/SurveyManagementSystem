package com.spec.surveymanagementsystem.service;

import com.spec.surveymanagementsystem.dto.OptionDTO;
import com.spec.surveymanagementsystem.dto.QuestionDTO;
import com.spec.surveymanagementsystem.dto.SurveyDTO;
import com.spec.surveymanagementsystem.exception.ResourceNotFoundException;
import com.spec.surveymanagementsystem.model.Organization;
import com.spec.surveymanagementsystem.model.Question;
import com.spec.surveymanagementsystem.model.QuestionOption;
import com.spec.surveymanagementsystem.model.Survey;
import com.spec.surveymanagementsystem.model.User;
import com.spec.surveymanagementsystem.repository.OrganizationRepository;
import com.spec.surveymanagementsystem.repository.QuestionOptionRepository;
import com.spec.surveymanagementsystem.repository.QuestionRepository;
import com.spec.surveymanagementsystem.repository.SurveyRepository;
import com.spec.surveymanagementsystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SurveyService {

	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private OrganizationRepository organizationRepository;

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private QuestionOptionRepository questionOptionRepository;

	@Transactional
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

		survey = surveyRepository.save(survey);

		for (QuestionDTO questionDTO : surveyDTO.getQuestions()) {
			Question question = new Question();
			question.setSurvey(survey);
			question.setTitle(questionDTO.getTitle());
			question.setType(questionDTO.getType());
			question.setRequired(questionDTO.isRequired());
			question.setStatus(true); // Assuming all questions are active by default

			question = questionRepository.save(question);

			for (String optionText : questionDTO.getOptions()) {
				QuestionOption option = new QuestionOption();
				option.setQuestion(question);
				option.setOptionText(optionText);
				option.setCreatedAt(new Date());
				option.setCreatedBy(surveyDTO.getUserId());
				option.setUpdatedAt(new Date());
				option.setUpdatedBy(surveyDTO.getUserId());

				questionOptionRepository.save(option);
			}
		}

		return survey;
	}

	public List<Survey> listSurveys() {
		return surveyRepository.findAll();
	}

	public Survey updateSurvey(Long surveyId, SurveyDTO surveyDTO) throws ResourceNotFoundException {
		Survey survey = surveyRepository.findById(surveyId)
				.orElseThrow(() -> new ResourceNotFoundException("Survey not found"));

		Organization organization = organizationRepository.findById(surveyDTO.getOrganizationId())
				.orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

		User updatedByUser = UserRepository.findById(surveyDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		survey.setUpdatedByUser(updatedByUser);
		survey.setTitle(surveyDTO.getTitle());
		survey.setDescriptions(surveyDTO.getDescriptions());
		survey.setStartDate(surveyDTO.getStartDate());
		survey.setExpirationDate(surveyDTO.getExpirationDate());
		survey.setSurveyLink(surveyDTO.getSurveyLink());
		survey.setOrganization(organization);

		// Update questions and options
		List<QuestionDTO> questionDTOs = surveyDTO.getQuestions();
		if (questionDTOs != null) {
			for (QuestionDTO questionDTO : questionDTOs) {
				Question question = new Question();
				question.setSurvey(survey);
				question.setTitle(questionDTO.getTitle());
				question.setType(questionDTO.getType());
				question.setRequired(questionDTO.isRequired());
				question.setStatus(true); // Assuming all questions are active by default

				question = questionRepository.save(question);

				List<String> options = questionDTO.getOptions();
				if (options != null) {
					for (String optionText : options) {
						QuestionOption option = new QuestionOption();
						option.setQuestion(question);
						option.setOptionText(optionText);
						option.setCreatedAt(new Date());
						option.setCreatedBy(surveyDTO.getUserId());
						option.setUpdatedAt(new Date());
						option.setUpdatedBy(surveyDTO.getUserId());

						questionOptionRepository.save(option);
					}
				}
			}
		}

		return surveyRepository.save(survey);
	}

	public void deleteSurvey(Long surveyId) {
	    Survey survey = surveyRepository.findById(surveyId)
	            .orElseThrow(() -> new ResourceNotFoundException("Survey not found"));

	    surveyRepository.delete(survey);
	}

	public Survey getSurveyById(Long surveyId) {
		return surveyRepository.findById(surveyId).orElseThrow(() -> new ResourceNotFoundException("Survey not found"));
	}
}
