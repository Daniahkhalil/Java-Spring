package com.codingdojo.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	 @RequestMapping("/")
	public String index(HttpSession session) {
		 
		 Integer count = (Integer)session.getAttribute("count"); 
			if (session.getAttribute("count") == null) {
				 session.setAttribute("count", 0);
				}
			
					return "index.jsp";
			
		
		
	}
	 
	 @RequestMapping("/yourserver")
		public String yourServer(HttpSession session, Model model) {   
			Integer currentCount = (Integer) session.getAttribute("count");
			if (session.getAttribute("count") == null) {
				currentCount = 0;
				session.setAttribute("count", currentCount);
			}
			
			else {
				session.setAttribute("count", currentCount + 1);
			}
			
	
			
			model.addAttribute("countToShow", currentCount);
			
			return "index.jsp";
		}
	 
	 @RequestMapping("/yourserver/count")
		public String count(HttpSession session, Model model) {      
	 
			Integer currentCount = (Integer) session.getAttribute("count");

			model.addAttribute("countToShow", currentCount);
			return "count.jsp";
		}

}
