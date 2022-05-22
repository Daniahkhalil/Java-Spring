package com.codingdojo.main.bookclub.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="countries")
public class Country {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	private Long id;
 	
    private String code;
	
    private String name;
	
    private boolean continent;
    private String region;
    private float surface_area;
    private String indep_year;
    private int population;
    private float life_exp;
    private float gnp;
    private float gnp_old;
    private String local_name;
    private String government_form;
    private String head_of_state;
    private int capital;
    private String code2;
    
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<City> city;
    
    
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<Language> language;
    
    
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Country() {
    	
    }
	
	public Country(String code, String name, boolean continent, String region, float surface_area, String indep_year,
			int population, float life_exp, float gnp, float gnp_old, String local_name, String government_form,
			String head_of_state, int capital, String code2, List<Language> language, List<City> city) {
		super();
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_exp = life_exp;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
		this.language = language;
		this.city = city;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getContinent() {
		return continent;
	}
	public void setContinent(boolean continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public float getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(float surface_area) {
		this.surface_area = surface_area;
	}
	public String getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(String indep_year) {
		this.indep_year = indep_year;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public float getLife_exp() {
		return life_exp;
	}
	public void setLife_exp(float life_exp) {
		this.life_exp = life_exp;
	}
	public float getGnp() {
		return gnp;
	}
	public void setGnp(float gnp) {
		this.gnp = gnp;
	}
	public float getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(float gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGovernment_form() {
		return government_form;
	}
	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}
	public String getHead_of_state() {
		return head_of_state;
	}
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}


}
