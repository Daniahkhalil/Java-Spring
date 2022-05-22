package com.codingdojo.main.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.main.productsandcategories.models.Category;
import com.codingdojo.main.productsandcategories.models.Product;
import com.codingdojo.main.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
//	 Product Specific Services	
	 public List<Product> allProduct() {
	        return productRepository.findAll();
	    }
	 
	 public Product createProduct(Product e) {
	        return productRepository.save(e);
	    }
	 
	 public Product findProduct(Long id) {
	        Optional<Product> optionalProduct = productRepository.findById(id);
	        if(optionalProduct.isPresent()) {
	            return optionalProduct.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public Product addCategory(Product product, Category category) {
		 product.getCategories().add(category);
		 return productRepository.save(product);
		 
	 }
	 
	 public List<Product> findbycategories(Category category){
			return productRepository.findAllByCategories(category);
		}
	 public List<Product> findbyCategoriesNotContan(Category category){
			return productRepository.findByCategoriesNotContains(category);
		}



}
