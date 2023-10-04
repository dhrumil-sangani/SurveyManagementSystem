package com.spec.osm.converter;

import com.spec.osm.dto.QuestionDTO;
import com.spec.osm.dto.QuestionOptionDTO;
import com.spec.osm.dto.SurveyDTO;
import com.spec.osm.entities.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SurveyConverter {

    public SurveyDTO convertEntityToDto(Survey survey) {
        SurveyDTO surveyDTO = new SurveyDTO();
        surveyDTO.setSurveyId(survey.getId());
        surveyDTO.setOrganizationId(survey.getOrganization() != null ? survey.getOrganization().getId() : null);
        surveyDTO.setTitle(survey.getTitle());
        surveyDTO.setDescriptions(survey.getDescriptions());
        surveyDTO.setStartDate(survey.getStartDate());
        surveyDTO.setExpirationDate(survey.getExpirationDate());
        surveyDTO.setStatus(survey.isStatus());
        surveyDTO.setCreatedByUserId(survey.getCreatedByUser() != null ? survey.getCreatedByUser().getId() : null);
        surveyDTO.setUpdatedByUserId(survey.getUpdatedByUser() != null ? survey.getUpdatedByUser().getId() : null);

        // Convert questions (assuming you have a method to convert Question entities to QuestionDTOs)
        List<QuestionDTO> questionDTOS = new ArrayList<>();
        for (Question question : survey.getQuestions()) {
            questionDTOS.add(questionToQuestionDTO(question));
        }

        surveyDTO.setQuestions(questionDTOS);

        return surveyDTO;
    }

    public QuestionDTO questionToQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionId(question.getId());
        questionDTO.setQuestionTitle(question.getTitle());
        questionDTO.setQuestionType(question.getType().toString()); // Assuming QuestionType is an enum
        questionDTO.setRequired(question.isRequired());
        questionDTO.setActive(question.isActive());
        questionDTO.setQuestionCreatedAt(question.getCreatedAt());
        questionDTO.setQuestionUpdatedAt(question.getUpdatedAt());

        // Convert question options (assuming you have a method to convert QuestionOption entities to QuestionOptionDTOs)
        List<QuestionOptionDTO> optionDTOs = new ArrayList<>();
        for (QuestionOption option : question.getQuestionsOptions()) {
            optionDTOs.add(questionOptionToQuestionOptionDTO(option));
        }
        questionDTO.setQuestionOptions(optionDTOs);

        return questionDTO;
    }


    public QuestionOptionDTO questionOptionToQuestionOptionDTO(QuestionOption option) {
        QuestionOptionDTO optionDTO = new QuestionOptionDTO();
        optionDTO.setOptionId(option.getId());
        optionDTO.setOptionText(option.getOptionText());

        return optionDTO;
    }


    public Survey convertDtoToEntity(SurveyDTO surveyDTO) {
        Survey survey = new Survey();
        survey.setId(surveyDTO.getSurveyId());
        if (surveyDTO.getOrganizationId() != null) {
            Organization organization = new Organization();
            organization.setId(surveyDTO.getOrganizationId());
            survey.setOrganization(organization);
        }
        survey.setTitle(surveyDTO.getTitle());
        survey.setDescriptions(surveyDTO.getDescriptions());
        survey.setStartDate(surveyDTO.getStartDate());
        survey.setExpirationDate(surveyDTO.getExpirationDate());
        survey.setStatus(surveyDTO.isStatus());
        if (surveyDTO.getCreatedByUserId() != null) {
            User createdByUser = new User();
            createdByUser.setId(surveyDTO.getCreatedByUserId());
            survey.setCreatedByUser(createdByUser);
        }
        if (surveyDTO.getUpdatedByUserId() != null) {
            User updatedByUser = new User();
            updatedByUser.setId(surveyDTO.getUpdatedByUserId());
            survey.setUpdatedByUser(updatedByUser);
        }

        // Convert questions (assuming you have a method to convert QuestionDTOs to Question entities)
        List<Question> questions = new ArrayList<>();
        for (QuestionDTO questionDTO : surveyDTO.getQuestions()) {
            questions.add(questionDTOToQuestion(questionDTO));
        }
        survey.setQuestions(questions);

        return survey;
    }

    public Question questionDTOToQuestion(QuestionDTO questionDTO) {
        List<Question> questions;
        Question question = new Question();
        question.setId(questionDTO.getQuestionId());
        question.setTitle(questionDTO.getQuestionTitle());
        question.setType(Question.QuestionType.valueOf(questionDTO.getQuestionType())); // Assuming QuestionType is an enum

        question.setRequired(questionDTO.isRequired()); // Set isRequired based on QuestionDTO
        question.setActive(questionDTO.isActive()); // Set isActive based on QuestionDTO

        System.out.println("DTO isRequired: " + questionDTO.isRequired());
        System.out.println("DTO isActive: " + questionDTO.isActive());
        question.setCreatedAt(questionDTO.getQuestionCreatedAt());
        question.setUpdatedAt(questionDTO.getQuestionUpdatedAt());

        // Convert question options (assuming you have a method to convert QuestionOptionDTOs to QuestionOption entities)
        List<QuestionOption> options = new ArrayList<>();
        for (QuestionOptionDTO optionDTO : questionDTO.getQuestionOptions()) {
            options.add(questionOptionDTOToQuestionOption(optionDTO));
        }
        question.setQuestionsOptions(options);

        return question;
    }

    public QuestionOption questionOptionDTOToQuestionOption(QuestionOptionDTO optionDTO) {
        QuestionOption option = new QuestionOption();
        option.setId(optionDTO.getOptionId());
        option.setOptionText(optionDTO.getOptionText());

        return option;
    }

}
