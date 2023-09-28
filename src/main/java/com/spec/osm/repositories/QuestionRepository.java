package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spec.osm.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
