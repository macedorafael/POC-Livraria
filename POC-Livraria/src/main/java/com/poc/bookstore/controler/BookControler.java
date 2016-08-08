package com.poc.bookstore.controler;

import java.util.List;

import javax.ejb.Local;

import com.poc.bookstore.json.dto.Book;

@Local
public interface BookControler {
	
	List<Book> getBooksByAuthor(String name);

	Book saveBook(Book book);

	Book getBookById(Long id);

}
