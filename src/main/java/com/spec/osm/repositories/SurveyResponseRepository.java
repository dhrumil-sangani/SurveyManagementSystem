package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.osm.entities.SurveyResponse;

public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {

}