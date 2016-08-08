package com.poc.bookstore.service;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.poc.bookstore.controler.BookControler;
import com.poc.bookstore.json.dto.Book;

@Path("book")
@Stateless
public class BookStoreService {

	@EJB
	private BookControler bookControler;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Book getBookById(@PathParam("id") Long id) {
		return bookControler.getBookById(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("author/{name}")
	public List<Book> getBookStoreByAuthor(@PathParam("name") String name){
		return bookControler.getBooksByAuthor(name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("inserir/livro")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveBook(Book book){
		Book b1 = bookControler.saveBook(book);
		URI uri = URI.create(String.format("/book/%s", b1.getId()));
		
		return Response.created(uri).build();
		
	}
}

















