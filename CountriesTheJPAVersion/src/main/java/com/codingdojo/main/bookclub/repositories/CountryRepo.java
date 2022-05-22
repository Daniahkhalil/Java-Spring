package com.codingdojo.main.bookclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.main.bookclub.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
	
	@Query("SELECT c.name , l.language ,l.percentage FROM Country c JOIN c.language l where l.language='Slovene' ORDER BY l.percentage DESC ")
	List<Object []>  countriesSpeakSlovene();
	
	@Query("SELECT c.name , l.language ,l.percentage FROM Country c JOIN c.language l where l.percentage <89  ORDER BY l.percentage DESC ")
	List<Object []>  countriesAndPer();
	
	@Query("SELECT c.name FROM Country c  where c.surface_area < 501 AND c.population >1000000 " )
	List<Object []>  countriesPopulation();
	 
    @Query(value="SELECT countries.name FROM countries JOIN cities on countries.id = cities.country_id WHERE  countries.life_expectancy > 75 and countries.surface_area < 200 and countries.government_form = 'Constitutional Monarchy' ;", nativeQuery=true)
    List<Object[]> expCountries();
    
    @Query(value="SELECT countries.name as x, cities.district, cities.name, cities.population FROM countries\r\n"
            + "JOIN cities ON countries.id = cities.country_id\r\n"
            + "WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000\r\n"
            + " ;", nativeQuery=true)
    List<Object[]> Countries();
    
    @Query(value="SELECT countries.region, COUNT(countries.name) FROM countries\r\n"
            + "GROUP BY countries.region\r\n"
            + "ORDER BY COUNT(countries.name) DESC\r\n"
            + " ;", nativeQuery=true)
    List<Object[]> regionCountries();
	


}
