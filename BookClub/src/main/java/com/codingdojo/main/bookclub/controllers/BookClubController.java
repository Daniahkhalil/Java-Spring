package com.codingdojo.main.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.main.bookclub.models.LoginUser;
import com.codingdojo.main.bookclub.models.User;
import com.codingdojo.main.bookclub.services.BookClubService;

@SpringBootApplication
@Controller
public class BookClubController {
	// Add once service is implemented:
    @Autowired
    private BookClubService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());// empty format
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
            return "home.jsp";
        }else {
            return "redirect:/";
        }
    }
   

   
   @PostMapping("/register")
   public String register(@Valid @ModelAttribute("newUser") User newUser, 
           BindingResult result, Model model, HttpSession session) {
       
       // TO-DO Later -- call a register method in the service 
       // to do some extra validations and create a new user!
   	
       User newUserReg=userServ.register(newUser, result);// if email not exists return null
       if(result.hasErrors()) {
           // Be sure to send in the empty LoginUser before 
           // re-rendering the page.
           model.addAttribute("newLogin", new LoginUser());// if there is an error return the index with empty object
           return "index.jsp";
       }
       
       // No errors! 
       // TO-DO Later: Store their ID from the DB in session, 
       // in other words, log them in.
       session.setAttribute("user", newUserReg);
   
       return "redirect:/home";
   }
   
   @PostMapping("/login")
   public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
           BindingResult result, Model model, HttpSession session) {
       
       // Add once service is implemented:
        User user = userServ.login(newLogin, result);
   
       if(result.hasErrors()) {
           model.addAttribute("newUser", new User());//return null then go to index again
           return "index.jsp";
       }
   
       // No errors! 
       // TO-DO Later: Store their ID from the DB in session, 
       // in other words, log them in.
       session.setAttribute("user", user);
   
       return "redirect:/home";
   }
   
   @GetMapping("/logout")
   public String logout(HttpSession session) { 
           session.invalidate();//close the session
           return "redirect:/";
       
   }
}
