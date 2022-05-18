package com.codingdojo.main.productsandcategories.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.main.productsandcategories.models.LoginUser;
import com.codingdojo.main.productsandcategories.models.User;
import com.codingdojo.main.productsandcategories.repositories.UserRepository;
    

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
     // TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	//optional return null if there is no object returned:null
        Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
        if(potentialUser.isPresent()) {
            result.rejectValue("email", "Matches", "This email already exist !");
            return null;
        }
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password & Password not matched !");
            return null;
        }
        if (result.hasErrors()) {
        	 return null;
        }
            
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
        
        // Hash and set password, save user to database
        
        }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
       	if (result.hasErrors()) {
    		return null;
    	}
        Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
        if(potentialUser.isEmpty()) {
            result.rejectValue("email", "notExist", "Please Register !");
            return null;
        }
        
        User logUser = potentialUser.get();
        if(!BCrypt.checkpw(newLoginObject.getPassword(), logUser.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        // Return null if result has errors
        if (result.hasErrors()) {
    		return null;
    	}
        else {
            return logUser;
        }
        
    }
}
