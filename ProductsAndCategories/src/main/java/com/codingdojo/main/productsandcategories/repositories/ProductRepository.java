package com.codingdojo.main.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.main.productsandcategories.models.Category;
import com.codingdojo.main.productsandcategories.models.Product;


@Repository
public interface ProductRepository  extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesContains(Category category);
	List<Product> findByCategoriesNotContains(Category category);

}
