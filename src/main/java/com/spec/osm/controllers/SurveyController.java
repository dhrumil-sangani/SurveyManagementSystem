package com.spec.osm.controllers;

import com.spec.osm.dto.SurveyDTO;
import com.spec.osm.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {


    @Autowired
    private SurveyService surveyService;

    @GetMapping("/Survey-List")
    public List<SurveyDTO> getAllSurvey(){
        return surveyService.getAllSurvey();
    }

    @PostMapping("/create")
    public ResponseEntity<SurveyDTO> createSurvey(@RequestBody SurveyDTO surveyDTO) {
        // Call the service's createSurvey method to create a survey
        SurveyDTO createdSurveyDTO = surveyService.createSurvey(surveyDTO);

        // Return the created SurveyDTO in the response
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSurveyDTO);
    }



}
