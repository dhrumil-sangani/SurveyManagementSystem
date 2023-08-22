package com.spec.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SurveyController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "index";
	}
}
