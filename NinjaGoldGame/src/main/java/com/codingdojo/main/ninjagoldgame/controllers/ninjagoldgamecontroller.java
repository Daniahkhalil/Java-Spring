package com.codingdojo.main.ninjagoldgame.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ninjagoldgamecontroller {
	
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
    	// If the gold is not already in session
		if (session.getAttribute("gold") == null) {
		// Use setAttribute to initialize the gold in session
			session.setAttribute("gold", 0);
			Integer currentGold = (Integer) session.getAttribute("gold");
			model.addAttribute("gold", currentGold);
		}
		else {
			Integer currentGold = (Integer) session.getAttribute("gold");
			model.addAttribute("gold", currentGold);
			ArrayList<String> currlog = (ArrayList<String>) session.getAttribute("log");
			model.addAttribute("log", currlog);
		}
		if (session.getAttribute("log") == null) {
			ArrayList<String> log = new ArrayList<String>();
			session.setAttribute("log", log);
			model.addAttribute("log", log);	
		}
		if ((Integer) session.getAttribute("gold") < -100) {
			return "redirect:/debt";
		}
		else {	
			ArrayList<String> currlog = (ArrayList<String>) session.getAttribute("log");
			ArrayList<String> revArrayList = new ArrayList<String>();
		        for (int i = currlog.size() - 1; i >= 0; i--) {
		 
		            // Append the elements in reverse order
		            revArrayList.add(currlog.get(i));
		        }
			model.addAttribute("arrLen", revArrayList);	
			return "index.jsp";
		}
	}
	

}
