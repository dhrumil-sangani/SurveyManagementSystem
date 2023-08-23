package com.spec.surveymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spec.surveymanagementsystem.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
