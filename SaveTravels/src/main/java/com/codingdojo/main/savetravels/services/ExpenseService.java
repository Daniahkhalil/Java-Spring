package com.codingdojo.main.savetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.main.savetravels.models.Expense;
import com.codingdojo.main.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	private final ExpenseRepository  expenseRepository ;
	
	 public ExpenseService(ExpenseRepository expenseRepository) {
	        this.expenseRepository = expenseRepository;
	    }
	 
	 public List<Expense> allExpense(){
		 return expenseRepository.findAll();
	 }
	 
	 public Expense createExpense(Expense e) {
		 return expenseRepository.save(e);
		 
	 }
	 
	 public Expense findExpense(Long id) {
	        Optional<Expense> optionalExpense = expenseRepository.findById(id);
	        if(optionalExpense.isPresent()) {
	            return optionalExpense.get();
	        } else {
	            return null;
	        }
	    }
	 


}
