package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.osm.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}