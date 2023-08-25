package com.spec.surveymanagementsystem.repository;

import com.spec.surveymanagementsystem.model.QuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
	// Add custom query methods if needed
}
