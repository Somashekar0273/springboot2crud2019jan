package com.springboot.beginner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeleafController {
	
	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}

}
