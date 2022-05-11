package com.codingdojo.main.booksaPI.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.main.booksaPI.models.Book;
import com.codingdojo.main.booksaPI.repositories.BookRepository;


@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		// TODO Auto-generated method stub
	     Book updatedbook=this.findBook(id);
	     if(updatedbook !=null) {
	    	 updatedbook.setTitle(title);
	    	 updatedbook.setDescription(desc);
	    	 updatedbook.setLanguage(lang);
	    	 updatedbook.setNumberOfPages(numOfPages);
	    	 
	    	 return bookRepository.save(updatedbook);
	     }
	     
		return null;
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
		
	}
}