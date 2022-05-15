package com.codingdojo.main.savetravels.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.main.savetravels.models.Expense;
import com.codingdojo.main.savetravels.services.ExpenseService;

@Controller
public class TravelController {
	
	@Autowired
	private final ExpenseService expenseService;
	
	
    public TravelController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}


	@GetMapping("/expense")
   public String allExpenses(@ModelAttribute("expense") Expense expense,Model model) {
    	List<Expense> allExpense=expenseService.allExpense();
    	model.addAttribute("expenses",allExpense);
    	return "/expense/index.jsp";
    }
	
	  @PostMapping("/expense/new")
	  public String create(@Valid @ModelAttribute("expense") Expense expense ,BindingResult result ,Model model) {
		  if(result.hasErrors()) {
			  	List<Expense> allExpense=expenseService.allExpense();
		    	model.addAttribute("expenses",allExpense);
			  return "/expense/index.jsp";
		  }else {
			  return  "redirect:/expenses";
			  }
		  
	  }
	  
	  @GetMapping("/expenses/{id}")
	    public String show(@PathVariable("id") Long id, Model model) {
	        Expense expense = expenseService.findExpense(id);
	        model.addAttribute("expense", expense);
	        return "/expense/show.jsp";
	    }
//	   @GetMapping("/expenses/{id}/edit")
//	    public String edit(@PathVariable("id") Long id, Model model) {
//	        Expense expense = expenseService.findExpense(id);
//	        model.addAttribute("expense", expense);
//	        return "/expense/edit.jsp";
//	    }

}

