package com.codingdojo.daikichipathvariables.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class DaikichiPathVariablesController {
	@RequestMapping("/daikichi/travel/{first}")
	public String showlesson(@PathVariable("first") String first ) {
		return "Congratulations! You will soon travel to "+first;
	}

	@RequestMapping("/daikichi/lotto/{num}")
	public String showlesson2(@PathVariable("num") Integer num ) {
		if(num %2 == 0) {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}else {
		return "You will take a grand journey in the near future, but be weary of tempting offers ";
		}
	}
		
}
