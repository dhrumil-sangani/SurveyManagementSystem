package com.spec.osm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spec.osm.entities.QuestionOption;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {

}
