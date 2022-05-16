package com.codingdojo.main.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.main.savetravels.models.Dojo;



public interface DojoRepository extends CrudRepository<Dojo,Long>  {

    // this method retrieves all the books from the database
    List<Dojo> findAll();
    // this method finds books with descriptions containing the search string
 

}
