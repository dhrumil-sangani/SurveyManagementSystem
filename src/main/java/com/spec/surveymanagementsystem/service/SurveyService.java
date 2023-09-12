package com.spec.surveymanagementsystem.service;

import com.spec.surveymanagementsystem.dto.OptionDTO;
import com.spec.surveymanagementsystem.dto.QuestionDTO;
import com.spec.surveymanagementsystem.dto.SurveyDTO;
import com.spec.surveymanagementsystem.exception.InvalidDataException;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

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
	public Survey createSurvey(@Valid SurveyDTO surveyDTO) throws ResourceNotFoundException {
		if (surveyDTO == null) {
			throw new InvalidDataException("Survey data is null");
		}

		if (surveyDTO.getTitle() == null || surveyDTO.getTitle().isEmpty()) {
			throw new InvalidDataException("Survey title is required");
		}

		if (surveyDTO.getQuestions() == null || surveyDTO.getQuestions().isEmpty()) {
			throw new InvalidDataException("At least one question is required");
		}

		// Get the organization from the database
		Organization organization = organizationRepository.findById(surveyDTO.getOrganizationId())
				.orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

		// Get the user who created the survey from the database
		User createdByUser = UserRepository.findById(surveyDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));

		// Create a new survey object
		Survey survey = new Survey();
		survey.setCreatedByUser(createdByUser);
		survey.setTitle(surveyDTO.getTitle());
		survey.setDescriptions(surveyDTO.getDescriptions());
		survey.setStartDate(surveyDTO.getStartDate());
		survey.setExpirationDate(surveyDTO.getExpirationDate());
		survey.setSurveyLink(surveyDTO.getSurveyLink());
		survey.setOrganization(organization);

		// Save the survey to the database
		surveyRepository.save(survey);

		// Create a hashmap to store the questions and their corresponding objects
		Map<QuestionDTO, Question> questionMap = new HashMap<>();

		// Iterate over the questions in the surveyDTO
		for (QuestionDTO questionDTO : surveyDTO.getQuestions()) {
			// Create a new question object
			Question question = new Question();
			question.setSurvey(survey);
			question.setTitle(questionDTO.getTitle());
			question.setType(questionDTO.getType());
			question.setRequired(questionDTO.isRequired());
			question.setStatus(true); // Assuming all questions are active by default

			// Save the question to the database
			questionRepository.save(question);

			// Add the question to the hashmap
			questionMap.put(questionDTO, question);
		}

		// Iterate over the questions in the hashmap
		for (Map.Entry<QuestionDTO, Question> entry : questionMap.entrySet()) {
			QuestionDTO questionDTO = entry.getKey();
			Question question = entry.getValue();

			// Create a list of question options
			List<QuestionOption> options = questionDTO.getOptions().stream().map(optionText -> {
				// Create a new question option object
				QuestionOption option = new QuestionOption();
				option.setQuestion(question);
				option.setOptionText(optionText);
				option.setCreatedAt(new Date());
				option.setCreatedBy(surveyDTO.getUserId());
				option.setUpdatedAt(new Date());
				option.setUpdatedBy(surveyDTO.getUserId());
				return option;
			}).collect(Collectors.toList());

			// Save the question options to the database
			questionOptionRepository.saveAll(options);
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
