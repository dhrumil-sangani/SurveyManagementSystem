package com.spec.osm.controllers;

import com.spec.osm.dto.SurveyDTO;
import com.spec.osm.exception.SurveyException;
import com.spec.osm.response.ResponseHandler;
import com.spec.osm.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/surveys")
public class SurveyController {


    @Autowired
    private SurveyService surveyService;

    @GetMapping("/Survey-List")
    public ResponseEntity<Object> getAllSurvey() {

        return ResponseHandler.responseBuilder("Survey List Successfully Fetched", HttpStatus.OK, surveyService.getAllSurvey(), HttpStatus.OK.value());
//        return surveyService.getAllSurvey();

    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSurvey(@RequestBody SurveyDTO surveyDTO) throws SurveyException {
        // Call the service's createSurvey method to create a survey
        SurveyDTO createdSurveyDTO = surveyService.createSurvey(surveyDTO);

        // Return the created SurveyDTO in the response
        return ResponseHandler.responseBuilder("Survey Created Successfully", HttpStatus.CREATED, createdSurveyDTO, HttpStatus.CREATED.value());
    }


}
