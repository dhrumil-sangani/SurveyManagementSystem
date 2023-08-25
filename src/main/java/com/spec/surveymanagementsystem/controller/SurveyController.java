package com.spec.surveymanagementsystem.controller;

import com.spec.surveymanagementsystem.dto.SurveyDTO;
import com.spec.surveymanagementsystem.model.Survey;
import com.spec.surveymanagementsystem.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@PostMapping("/createSurvey")
	public ResponseEntity<Survey> createSurvey(@RequestBody @Validated SurveyDTO surveyDTO) {
		Survey createdSurvey = surveyService.createSurvey(surveyDTO);
		return new ResponseEntity<>(createdSurvey, HttpStatus.CREATED);
	}

	@GetMapping("/getAllSurveys")
	public ResponseEntity<List<Survey>> listSurveys() {
		List<Survey> surveys = surveyService.listSurveys();
		return new ResponseEntity<>(surveys, HttpStatus.OK);
	}

	@PutMapping("/update/{surveyId}")
	public ResponseEntity<Survey> updateSurvey(@PathVariable Long surveyId,
			@RequestBody @Validated SurveyDTO surveyDTO) {
		Survey updatedSurvey = surveyService.updateSurvey(surveyId, surveyDTO);
		return new ResponseEntity<>(updatedSurvey, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{surveyId}")
	public ResponseEntity<String> deleteSurvey(@PathVariable Long surveyId) {
		surveyService.deleteSurvey(surveyId);
		return new ResponseEntity<>("Survey with ID " + surveyId + " has been deleted.", HttpStatus.OK);
	}

	@GetMapping("/getSurveyById/{surveyId}")
	public ResponseEntity<Survey> getSurveyById(@PathVariable Long surveyId) {
		Survey survey = surveyService.getSurveyById(surveyId);
		return new ResponseEntity<>(survey, HttpStatus.OK);
	}
}
