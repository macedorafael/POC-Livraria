package com.poc.bookstore.controler.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.poc.bookstore.controler.BookControler;
import com.poc.bookstore.dao.BookDao;
import com.poc.bookstore.json.dto.Book;

@Stateless
public class BookControlerImpl implements BookControler {
	
	@EJB
	private BookDao bookDao; 

	@Override
	public List<Book> getBooksByAuthor(String name) {
		return bookDao.getBooksByAuthor(name);
	}
	
	@Override
	public Book saveBook(Book book){
		return bookDao.saveBook(book);
	}
	
	@Override
	public Book getBookById(Long id){
		return bookDao.getBookById(id);
	}

}
