package com.spec.surveymanagementsystem.repository;

import com.spec.surveymanagementsystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	// Add custom query methods if needed
}
