package com.codingdojo.main.bookclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.main.bookclub.models.City;




@Repository
public interface CityRepo extends CrudRepository<City, Long>  {
	@Query("SELECT c.name , COUNT(c) FROM City  c JOIN c.country co GROUP BY co  order by COUNT(c) desc")
	List<Object []>  citiesAndNumbers();	
}
