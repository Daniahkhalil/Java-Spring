package com.codingdojo.main.savetravels.services;

import java.util.List;

import org.springframework.stereotype.Service;


import com.codingdojo.main.savetravels.models.Ninja;

import com.codingdojo.main.savetravels.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		super();
		this.ninjaRepository = ninjaRepository;
	}
	
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    
    public Ninja createNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    
    public Ninja updateNinja(Ninja n) {
        return ninjaRepository.save(n);
    }
    
    
    public void deleteNinja(Long id) {
  		Ninja deleteNinja = ninjaRepository.findById(id).orElse(null); 
  		ninjaRepository.delete(deleteNinja);
  	}


}
