package com.codingdojo.main.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.codingdojo.main.savetravels.models.Ninja;



public interface NinjaRepository extends CrudRepository<Ninja,Long> {
    // this method retrieves all the books from the database
    List<Ninja> findAll();
    // this method finds books with descriptions containing the search string

}
