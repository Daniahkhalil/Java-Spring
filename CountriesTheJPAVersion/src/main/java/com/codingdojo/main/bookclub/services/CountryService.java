package com.codingdojo.main.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.main.bookclub.repositories.CountryRepo;

@Service
public class CountryService {
	
	@Autowired
	private  CountryRepo countryRepo;
	
	public List<Object []> countriesSpeakSlovene(){
		
		
		return countryRepo.countriesSpeakSlovene();
		
	}
	
	

}
