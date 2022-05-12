package com.codingdojo.main.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class ninjagoldgamecontroller {
	
@RequestMapping("/gold")
public String index(HttpSession session  , Model model) {
	
	if(session.getAttribute("gold")== null){
		
		session.setAttribute("gold", 0);
		Integer currentGold=(Integer) session.getAttribute("gold");
		model.addAttribute("gold",currentGold);
	}
		else {
			Integer CurrentGold=(Integer) session.getAttribute("gold");
			model.addAttribute("gold",CurrentGold);
			ArrayList <String> currLog=new ArrayList<String>();
			model.addAttribute("log",currLog);
			
		}
		
	if(session.getAttribute("log")==null) {
		
		ArrayList <String> log=new ArrayList<String>();
		session.setAttribute("log", log);
		model.addAttribute("log",log);
		
		
		
	}
		
	if((Integer) session.getAttribute("gold") <-100) {
		return "dept.jsp";
	}else {
		ArrayList<String> currLog = (ArrayList<String>) session.getAttribute("log");
		ArrayList <String> revArray=new ArrayList<String>();
		for(int i=currLog.size()-1; i>=0; i--) {
			revArray.add(currLog.get(i));
		}
		model.addAttribute("arr",revArray);
		return "index.jsp";
	
	}

		
	
	

}

@RequestMapping("/process")
public String process(HttpSession session,
 @RequestParam(value="gold") String gold ){
	
	Date date = new Date();
	java.text.DateFormat df = new java.text.SimpleDateFormat("MMMM dd  YYYY k:mm  a");
	String formatedDate = df.format(new java.util.Date());
	ArrayList <String> currLog=new ArrayList<String>();
	if(gold.equals("farm")) {
		Random rand = new Random();
		int num=rand.nextInt(20-10)+10;
		Integer currentGold=(Integer) session.getAttribute("gold");
		currentGold+=num;
		System.out.println(currentGold);
		session.setAttribute("gold",currentGold );
		currLog.add("<p style = 'color: green;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
		session.setAttribute("log", currLog);
		
		
	} else if(gold.equals("cave")) {
		Random rand=new Random();
		int num =  rand.nextInt(10 - 5) + 5;
		Integer currentGold=(Integer) session.getAttribute("gold");
		currentGold+=num;
		session.setAttribute("gold",currentGold );
		currLog.add("<p style = 'color: green;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
		session.setAttribute("log", currLog);
		
		
	}else if(gold.equals("house")) {
		Random rand=new Random();
		int num =  rand.nextInt(5 - 2) + 5;
		Integer currentGold=(Integer) session.getAttribute("gold");
		currentGold+=num;
		session.setAttribute("gold",currentGold );
		currLog.add("<p style = 'color: green;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
		session.setAttribute("log", currLog);
		
		
	}else if (gold.equals("quest")) {
		Random rand = new Random();
		int num =  rand.nextInt(50 + 50) - 50;
		Integer currentGold=(Integer) session.getAttribute("gold");
		currentGold+=num;
		session.setAttribute("gold",currentGold );
			if(num<0) {
					currLog.add("<p style = 'color: red;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
					session.setAttribute("log", currLog);
			}else if(num<0) {
					currLog.add("<p style = 'color: green;'>You entered a farm and earned " + num + " gold. ( " + formatedDate + " )</p>");
					session.setAttribute("log", currLog);
					
		}
	}
		
		
		
	return "redirect:/gold";
}
	


@RequestMapping("/reset")
public String reset(HttpSession session , Model model) {
	session.setAttribute("gold", 0);
	session.setAttribute("log", null);
	return "redirect:/gold";
}

@RequestMapping("/dept")
public String dept(){
	return "dept.jsp";
	
}
}
