package com.spec.osm.services;

import com.spec.osm.converter.SurveyConverter;
import com.spec.osm.dto.QuestionDTO;
import com.spec.osm.dto.QuestionOptionDTO;
import com.spec.osm.dto.SurveyDTO;
import com.spec.osm.entities.*;
import com.spec.osm.exception.SurveyException;
import com.spec.osm.exception.SurveyNotFoundException;
import com.spec.osm.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final SurveyConverter surveyConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionOptionRepository questionOptionRepository;


    @Autowired
    public SurveyService(SurveyRepository surveyRepository, SurveyConverter surveyConverter) {
        this.surveyRepository = surveyRepository;
        this.surveyConverter = surveyConverter;  // Inject SurveyConverter
    }

    public List<SurveyDTO> getAllSurvey() {

        return surveyRepository.findAll().stream().map(surveyConverter::convertEntityToDto)  // Use method reference
                .collect(Collectors.toList());
    }

    public SurveyDTO createSurvey(SurveyDTO surveyDTO) throws SurveyException {
        try {
            // Convert SurveyDTO to Survey entity
            Survey surveyEntity = surveyConverter.convertDtoToEntity(surveyDTO);

            // Set the Organization (if organizationId is provided)
            if (surveyDTO.getOrganizationId() != null) {
                Organization organization = organizationRepository.findById(surveyDTO.getOrganizationId())
                        .orElseThrow(() -> new SurveyNotFoundException("Organization not found"));
                surveyEntity.setOrganization(organization);
            }

            // Set the createdByUser (if createdByUserId is provided)
            if (surveyDTO.getCreatedByUserId() != null) {
                User createdByUser = userRepository.findById(surveyDTO.getCreatedByUserId())
                        .orElseThrow(() -> new SurveyNotFoundException("User not found"));
                surveyEntity.setCreatedByUser(createdByUser);
            }

            // Create a list to store questions
            List<Question> questions = new ArrayList<>();

            // Iterate over the questions in the surveyDTO and create both questions and options
            for (QuestionDTO questionDTO : surveyDTO.getQuestions()) {
                // Create a new Question entity
                Question question = surveyConverter.questionDTOToQuestion(questionDTO);

                // Set the survey using the generated survey_id
                question.setSurvey(surveyEntity);

                // Create a list to store question options
                List<QuestionOption> options = new ArrayList<>();
                for (QuestionOptionDTO optionDTO : questionDTO.getQuestionOptions()) {
                    QuestionOption option = surveyConverter.questionOptionDTOToQuestionOption(optionDTO);
                    // Set the question using the existing Question entity
                    option.setQuestion(question);
                    options.add(option);
                }

                // Set the options for the question
                question.setQuestionsOptions(options);

                // Add the question to the list of questions
                questions.add(question);
            }

            // Set the questions for the survey
            surveyEntity.setQuestions(questions);

            // Save the survey entity to the database with associated questions and options
            surveyEntity = surveyRepository.save(surveyEntity);

            // Convert the saved survey entity back to SurveyDTO
            return surveyConverter.convertEntityToDto(surveyEntity);

        } catch (SurveyNotFoundException ex) {
            // Return a simple error response
            throw new SurveyException(ex.getMessage(), ex.getCause(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            ex.printStackTrace(); // Example: Print the error to the console
            throw new SurveyException("An error occurred while creating the survey", ex.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}


