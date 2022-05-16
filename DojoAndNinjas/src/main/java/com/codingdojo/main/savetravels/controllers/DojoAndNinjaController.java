package com.codingdojo.main.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.main.savetravels.models.Dojo;
import com.codingdojo.main.savetravels.models.Ninja;
import com.codingdojo.main.savetravels.services.DojoService;
import com.codingdojo.main.savetravels.services.NinjaService;

@SpringBootApplication
@Controller
public class DojoAndNinjaController {

	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoAndNinjaController(DojoService dojoService, NinjaService ninjaService) {
		super();
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos=dojoService.allDojos();
		model.addAttribute("dojos",allDojos);
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
	     if (result.hasErrors()) {
	            return "ninja.jsp";
	        } else {
	        	ninjaService.createNinja(ninja);
	            return "redirect:/dojos";
	        }
	    }
	
	@GetMapping("/dojos")
    public String newDojo(@ModelAttribute("dojos") Dojo dojo, Model model) {
		List<Dojo> allDojos=dojoService.allDojos();
		model.addAttribute("dojos", allDojos );

        return "dojo.jsp";
    }
//	
	  @PostMapping("/dojos/new")
	    public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		  if(result.hasErrors()) {
		        return "index.jsp";
			  
		  }else {
			  dojoService.createDojo(dojo);
			  model.addAttribute(dojo);
	            return "redirect:/dojos";
		  }
		  
	  }
	
	@GetMapping("/dojos/new")
    public String Dojo(@ModelAttribute("dojo") Dojo dojo) {
        return "index.jsp";
    }
	@GetMapping("/dojo/{id}")
	public String show(@PathVariable("id")Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas=dojo.getNinjas();
		model.addAttribute("ninjas",ninjas);
		return "show.jsp";
	}
	

}
