package com.spec.surveymanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.spec.surveymanagementsystem.*")
public class SurveyManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyManagementSystemApplication.class, args);
	}
}
