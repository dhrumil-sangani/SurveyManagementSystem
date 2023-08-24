package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.surveymanagementsystem.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
