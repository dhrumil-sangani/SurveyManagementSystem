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
	
}
