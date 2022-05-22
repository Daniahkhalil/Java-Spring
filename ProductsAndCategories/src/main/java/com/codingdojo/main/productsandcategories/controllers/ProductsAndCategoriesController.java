package com.codingdojo.main.productsandcategories.controllers;



import java.util.List;

import javax.validation.Valid;

import com.codingdojo.main.productsandcategories.models.Category;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.main.productsandcategories.models.Product;
import com.codingdojo.main.productsandcategories.services.CategoryService;
import com.codingdojo.main.productsandcategories.services.ProductService;

@SpringBootApplication
@Controller
public class ProductsAndCategoriesController {
	
	private final CategoryService catServ;
	private final ProductService proServ;
	
	public ProductsAndCategoriesController(CategoryService catserv, ProductService proserv) {
		this.catServ = catserv;
		this.proServ = proserv;
	}
	
	//homepage
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = proServ.allProduct();
		List<Category> categories = catServ.allCategories();
		model.addAttribute("product",products);
		model.addAttribute("category",categories);
		return "index.jsp";
	}
	
	
	//ShowCategories
	@RequestMapping("/categories")
	public String showCategories(@ModelAttribute("category") Category category ,Model model) {
		List<Category> categories=catServ.allCategories();
		model.addAttribute("categories", categories);
		return "category.jsp";
		
	}
	
	@GetMapping("/category/new")
	public String newcategory(@ModelAttribute("category") Category category) {
		
		return "newCategory.jsp";
	}
	
	

	@PostMapping("/category/new")
	public String createcategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newCategory.jsp";
	        } else {
	        	catServ.createCategory(category);
	    return "redirect:/";
	        }
	}
	
	//show category
//	@GetMapping("/categories/{id}")
//	public String showCategory(@PathVariable("id") Long id , Model model) {
//		Category category=catServ.findCategory(id);
//		model.addAttribute("category", category);
//		return "showCategory.jsp";
//		
//	}
	
	@GetMapping("/product/{id}")
	public String productpage(Model model,@PathVariable Long id) {
		
		List<Category> categories = catServ.findbyproducts(proServ.findProduct(id));
		List<Category> categorie=catServ.findCategoriesNotInProduct(proServ.findProduct(id));
		
		model.addAttribute("product",proServ.findProduct(id));
		model.addAttribute("category",categories);
		model.addAttribute("cat",categorie);
		return "product.jsp";
	}
	
	@PostMapping("/product/{id}")
	public String addProductToCategory(@PathVariable("id")Long product_id,@RequestParam("categories")Long category_id) {
		Product thisProduct=proServ.findProduct(product_id);
		Category thisCategory=catServ.findCategory(category_id);
		
		proServ.addCategory(thisProduct,thisCategory);
		return "redirect:/product/"+product_id;
	}
	
	//Show Products
	@RequestMapping("/products")
	public String showProducts(@ModelAttribute("product") Product product ,Model model) {
		List<Product> products=proServ.allProduct();
		model.addAttribute("products", products);
		return "product.jsp";
		
	}
	
	//NewCategory
	@GetMapping("/product/new")
	public String newproduct(@ModelAttribute("product") Product product) {
		
		return "newProduct.jsp";
	}
		
		

	@PostMapping("/product/new")
	public String createproduct(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newProduct.jsp";
	        } else {
	        	proServ.createProduct(product);
	    return "redirect:/";
	        }
	}
		
		
		//show category
		@GetMapping("/products/{id}")
		public String showProduct(@PathVariable("id") Long id , Model model) {
			Product product=proServ.findProduct(id);
			model.addAttribute("product", product);
			return "showProduct.jsp";
			
		}
		@GetMapping("/category/{id}")
		public String categorypage(Model model,@PathVariable Long id) {
			List<Product> products = proServ.findbycategories(catServ.findCategory(id));
			List<Product> product=proServ.findbyCategoriesNotContan(catServ.findCategory(id));
			
			model.addAttribute("category",catServ.findCategory(id));
			model.addAttribute("product",products);
			model.addAttribute("pro",product);
			return "category.jsp";
		}
		
		@PostMapping("/category/{id}")
		public String addCategoryToPtoduct(@PathVariable("id")Long category_id,@RequestParam("products")Long product_id) {
			Product thisProduct=proServ.findProduct(product_id);
			Category thisCategory=catServ.findCategory(category_id);
			
			catServ.associate(thisProduct,thisCategory);
			return "redirect:/category/"+category_id;
		}
	

}
