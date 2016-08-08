package com.poc.bookstore.dao;

import java.util.List;

import javax.ejb.Local;

import com.poc.bookstore.json.dto.AuthorList;
import com.poc.bookstore.json.dto.Book;

@Local
public interface BookDao {
	
	AuthorList getAllAuthor();

	List<Book> getBooksByAuthor(String name);
	
	Book saveBook(Book book);

	Book getBookById(Long id);

}
