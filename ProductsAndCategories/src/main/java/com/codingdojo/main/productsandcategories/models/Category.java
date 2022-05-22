package com.codingdojo.main.productsandcategories.models;

import java.util.Date;
import java.util.List;


import javax.persistence.*;




@Entity
@Table(name="categories")
public class Category {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	     name = "categories_products", 
    	        joinColumns = @JoinColumn(name = "category_id"), 
    	        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    
    public Category() {
        
    }

	

	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}



	
	public Long getId() {
		return id;
	}




	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    

}
