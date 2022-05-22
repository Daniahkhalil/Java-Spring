package com.codingdojo.main.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.main.productsandcategories.models.Category;
import com.codingdojo.main.productsandcategories.models.Product;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findAllByProducts(Product product);
	List<Category> findByProductsContains(Product product);
	List<Category> findByProductsNotContains(Product product);
	
	

}
