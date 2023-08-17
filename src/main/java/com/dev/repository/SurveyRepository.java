package com.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.model.Survey;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
}
