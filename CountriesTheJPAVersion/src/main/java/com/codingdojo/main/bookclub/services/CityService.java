package com.codingdojo.main.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.codingdojo.main.bookclub.repositories.CityRepo;

@Service
public class CityService {
	@Autowired
	private CityRepo cityRepo;
	
	public List<Object []> citiesAndNumbers(){
		return cityRepo.citiesAndNumbers();
	}
	

}
