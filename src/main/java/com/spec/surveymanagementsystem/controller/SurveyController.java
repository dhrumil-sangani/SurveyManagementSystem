package com.spec.surveymanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spec.surveymanagementsystem.model.Survey;
import com.spec.surveymanagementsystem.service.SurveyService;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {
//	@ResponseBody
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String login() {
//		return "index";
//	}

	@Autowired
	private SurveyService surveyService;

	@GetMapping("/getAllSurveys")
	public ResponseEntity<List<Survey>> getAllSurveys() {
		try {
			List<Survey> surveys = surveyService.getAllSurveys();
			return new ResponseEntity<>(surveys, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Survey> updateSurvey(@PathVariable Long id, @RequestBody Survey updatedSurvey) {
		Survey updated = surveyService.updateSurvey(id, updatedSurvey);
		return ResponseEntity.ok(updated);
	}
}
