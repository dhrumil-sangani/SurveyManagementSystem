package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spec.surveymanagementsystem.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {


}
