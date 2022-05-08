package com.codingdojo.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloHumanController {
	@RequestMapping("")
	public String index(@RequestParam("name") String searchQuery) {
		
		return "Hello "+searchQuery;
		
	}

}
