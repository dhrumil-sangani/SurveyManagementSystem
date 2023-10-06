package com.spec.osm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spec.osm")

public class OnlineSurveyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineSurveyManagementApplication.class, args);
	}
}
