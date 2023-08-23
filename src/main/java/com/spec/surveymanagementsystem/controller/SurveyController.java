package com.spec.surveymanagementsystem.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SurveyController {
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "index";
	}
}
