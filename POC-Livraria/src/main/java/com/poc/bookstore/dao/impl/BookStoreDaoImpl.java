package com.poc.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import com.poc.bookstore.dao.BookDao;
import com.poc.bookstore.json.dto.Author;
import com.poc.bookstore.json.dto.AuthorList;
import com.poc.bookstore.json.dto.Book;

@Stateless
public class BookStoreDaoImpl implements BookDao{
	
	private static List<Book> books = new ArrayList<Book>();
	
	static{
		Author rafael = new Author("Rafael Macedo");
		Author amanda = new Author("Amanda Macedo");
		Author isis = new Author("Isis Macedo");
		
		books.add( new Book(1L, "Book - 1", Arrays.asList(rafael, amanda) ));
		books.add( new Book(1L, "Book - 2", Arrays.asList(amanda) ));
		books.add( new Book(1L, "Book - 3", Arrays.asList(rafael) ));
		books.add( new Book(1L, "Book - 4", Arrays.asList(isis, amanda) ));
		books.add( new Book(1L, "Book - 5", Arrays.asList(isis) ));
	}

	@Override
	public AuthorList getAllAuthor() {
		List<Author> list = Arrays.asList(new Author("Rafael"), new Author("Macedo"));
		AuthorList l = new AuthorList(list);
		return l;
	}

	@Override
	public List<Book> getBooksByAuthor(String name) {
		
		List<Book> returnBooks = new ArrayList<Book>();
		for(Book dto : books)
			AUTHOR:
			for(Author author : dto.getAuthors())
				if(author.getNome().contains(name)){
					returnBooks.add(dto);
					break AUTHOR;
				}
			
		return returnBooks;
	}

	@Override
	public Book saveBook(Book book) {
		books.add(book);
		return book;
	}
	
	@Override
	public Book getBookById(Long id){
		for(Book b : books)
			if(id.equals(b.getId()))
				return b;
		return null;
	}

}


























