package com.codingdojo.main.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.main.bookclub.models.Book;
import com.codingdojo.main.bookclub.models.LoginUser;
import com.codingdojo.main.bookclub.models.User;
import com.codingdojo.main.bookclub.services.BookService;
import com.codingdojo.main.bookclub.services.UserService;



@Controller
public class HomeController {
    
    // Add once service is implemented:
     @Autowired
     private UserService userServ;
     @Autowired
     private BookService bookServ;
     
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
        session.setAttribute("userId", newUserReg.getId());
    
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
        session.setAttribute("userId", user.getId());

     
        return "redirect:/books";
    }
    
    @GetMapping("/books")
    public String books(Model model,HttpSession session) {
    	if(session.getAttribute("userId")!=null) {
    		
    		Long userId=(Long)session.getAttribute("userId");
    		User currenUser=userServ.findbyId(userId);
    		model.addAttribute("currentUser", currenUser);
    		System.out.println(userId);    		
    		List<Book> books=bookServ.allBooks();
			model.addAttribute("books",books);
    		return "books.jsp";
    	}

    	return "redirect:/";
    }
    
    @GetMapping("/show/{id}")
    public String showbook(@PathVariable("id") Long id,Model model) {
    	Book book=bookServ.findBook(id);
    	model.addAttribute("book",book);
    	return "showBook.jsp";
    	
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();//close the session
            return "redirect:/";
        
    }
    
    @GetMapping("/books/new")
    public String addBook(@ModelAttribute("newBook") Book book) {
       
    return "addBook.jsp";
}
    
    @PostMapping("/books/new")
    public String addBook(@Valid @ModelAttribute("newBook") Book newBook, 
            BindingResult result ,HttpSession session) {
    	if(result.hasErrors()) {
    		return "addBook.jsp";
    		
    	}else {
    		Long userId=(Long)session.getAttribute("userId");
    	    User currenUser=userServ.findbyId(userId);
    	    newBook.setUser(currenUser);
    	    bookServ.createBook(newBook);
    		return "redirect:/home";
    		
    	}
        

    
    }
}
