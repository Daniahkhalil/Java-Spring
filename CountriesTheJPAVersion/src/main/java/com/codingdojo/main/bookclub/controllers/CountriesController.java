package com.codingdojo.main.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.codingdojo.main.bookclub.services.CityService;
import com.codingdojo.main.bookclub.services.CountryService;

@Controller
public class CountriesController {
	@Autowired
	private CountryService countryServ;
	@Autowired
	private CityService cityServ;
	
	@GetMapping("/")
	public String index(Model model){
		
		List<Object []>  countries=countryServ.countriesSpeakSlovene();
		model.addAttribute("countries", countries);
		System.out.println(countries);
		return "index.jsp";
		
	}
	
	@GetMapping("/city")
	public String City(Model model){
		
		List<Object []>  Cities=cityServ.citiesAndNumbers();
		System.out.println(Cities);
		return "index.jsp";
		
	}

}
