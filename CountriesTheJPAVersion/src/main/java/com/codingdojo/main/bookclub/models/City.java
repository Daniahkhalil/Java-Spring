package com.codingdojo.main.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cities")
public class City {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
 	
    private String country_code;
	
    private String name;
    private String district;
    private int population;
    
    
   	@Column(updatable=false)
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private Date createdAt;
       @DateTimeFormat(pattern="yyyy-MM-dd")
       private Date updatedAt;
    @ManyToOne( fetch  = FetchType.LAZY)
    @JoinColumn(name="country_id")
    private Country country;
    public City() {
    	
    }
    
	public City(String country_code, String name, String district, int population, Country country) {
		this.country_code = country_code;
		this.name = name;
		this.district = district;
		this.population = population;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	

}
