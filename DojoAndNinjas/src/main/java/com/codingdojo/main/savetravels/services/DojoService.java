package com.codingdojo.main.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.main.savetravels.models.Dojo;
import com.codingdojo.main.savetravels.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		super();
		this.dojoRepository = dojoRepository;
	}
	
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    
    public Dojo createDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    
    public Dojo updateDojo(Dojo d) {
        return dojoRepository.save(d);
    }
    
    
    public void deleteDojo(Long id) {
  		Dojo deleteDojo = dojoRepository.findById(id).orElse(null); 
  		dojoRepository.delete(deleteDojo);
  	}
    
	 public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }

}
