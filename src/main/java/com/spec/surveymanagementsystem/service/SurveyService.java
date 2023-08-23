package com.spec.surveymanagementsystem.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spec.surveymanagementsystem.model.Survey;
import com.spec.surveymanagementsystem.repository.SurveyRepository;

@Service
public class SurveyService {
	@Autowired
	private SurveyRepository surveyRepository;

	public List<Survey> getAllSurveys() {
		try {
			
			return surveyRepository.findAll();
		}catch(Exception ex) {
			 ex.printStackTrace();
			 return null;
		}
	}

	public Survey updateSurvey(Long id, Survey updatedSurvey) {
        Survey existingSurvey = surveyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Survey not found"));
        System.out.println(id);

        existingSurvey.setTitle(updatedSurvey.getTitle());
        existingSurvey.setDescriptions(updatedSurvey.getDescriptions());
        existingSurvey.setStart_date(updatedSurvey.getStart_date());
        existingSurvey.setExpiration_date(updatedSurvey.getExpiration_date());
        existingSurvey.setStatus(updatedSurvey.getStatus());
        existingSurvey.setSurvey_link(updatedSurvey.getSurvey_link());
        existingSurvey.setSurveyQuestions(updatedSurvey.getSurveyQuestions());

        return surveyRepository.save(existingSurvey);
    }
	
	
}
