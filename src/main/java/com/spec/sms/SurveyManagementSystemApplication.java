package com.spec.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dev.*")
public class SurveyManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyManagementSystemApplication.class, args);
	}
}
