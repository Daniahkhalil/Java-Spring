package com.codingdojo.main.productsandcategories.services;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.codingdojo.main.productsandcategories.models.Category;
import com.codingdojo.main.productsandcategories.models.Product;
import com.codingdojo.main.productsandcategories.repositories.CategoryRepository;



@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

//	 Category Specific Services		
	
	 public List<Category> allCategories() {
	        return categoryRepository.findAll();
	    }
	 
	 public Category createCategory(Category e) {
	        return categoryRepository.save(e);
	    }
	 
	 public Category findCategory(Long id) {
	        Optional<Category> optionalCategory = categoryRepository.findById(id);
	        if(optionalCategory.isPresent()) {
	            return optionalCategory.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public List<Category> findCategoriesInProduct(Product product){
		 return categoryRepository.findByProductsContains(product);
	 }
	 
	 public List<Category> findCategoriesNotInProduct(Product product){
		 return categoryRepository.findByProductsNotContains(product);
	 }
	 public List<Category> findbyproducts(Product product){
			return categoryRepository.findAllByProducts(product);
		}
	 
	 public void associate(Product thisproduct, Category thiscategory ) {
		 thisproduct.getCategories().add(thiscategory);
		 categoryRepository.save(thiscategory);
		 
	 }
	 
	 public Category addCategory(Product product, Category category) {
		 category.getProducts().add(product);
		 return categoryRepository.save(category);
		 
	 }


	 
	 

}
