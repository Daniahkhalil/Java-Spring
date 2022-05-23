package com.codingdojo.main.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.main.bookclub.models.Book;
import com.codingdojo.main.bookclub.models.User;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findAll();
	Optional<Book> findByTitle(String title);
	Optional<Book> findByAuthor(String author);
//	  List<Book> findAllByBorrowedBy(User user);
}
