package com.codingdojo.firstproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DaikichiController {
	
	@RequestMapping("/daikichi")
	 public String Welcome(){
       return "Welcome!";
}
	
	@RequestMapping("/today")
	 public String Today(){
      return "Today you will find luck in all your endeavors!";
}
	@RequestMapping("/tomorrow")
	 public String Tomorrow(){
     return "Tomorrow,an apportunity will arise, so be sure to be open to new ideas!";
}
}
