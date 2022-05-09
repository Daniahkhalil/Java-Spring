package com.codingdojo.displaydate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;  

@Controller
public class DisplayDateController {
	  @RequestMapping("/")
	    public String index() {
	      
	        return "index.jsp";
	    }
	  @RequestMapping("/time")
	    public String time(Model model) {
			//Displaying current time in 12 hour format with AM/PM
	    	DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
	    	String dateString = dateFormat.format(new Date()).toString();
	    	model.addAttribute("time",dateString);
	      
	        return "time.jsp";
	    }
	  
	  @RequestMapping("/date")
	    public String date(Model model) {

		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");  
		   LocalDateTime date = LocalDateTime.now();  
		   String dateFormat = dtf.format(date);
		   DayOfWeek day=date.getDayOfWeek();
		   model.addAttribute("date",dateFormat);
		   model.addAttribute("day",day);
		   
	   
	      
	      
	        return "date.jsp";
	    }
}
