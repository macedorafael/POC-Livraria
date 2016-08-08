package com.poc.bookstore.service;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.poc.bookstore.json.dto.Author;
import com.poc.bookstore.json.dto.Book;

public class BookStoreServiceTeste {
	
	@Before
	public void init(){
		RestAssured.baseURI = "http://localhost:8180/POC-Livraria";
		RestAssured.port = 8180;
	}
	
	@Test
	public void testingConectionOfBookStore(){
//		JsonPath path = get("/book").andReturn().jsonPath();
//		JsonPath path = given().header("Accept", "application/json").expect().statusCode(200).get("/book").andReturn().jsonPath();
//		
//		Author a1 = path.getObject("authors[0]", Author.class);
//		Author a2 = path.getObject("authors[1]", Author.class);
//		
//		assertEquals(a1.getNome(), "Rafael");
//		assertEquals(a2.getNome(), "Macedo");
	}
	
	@Test
	public void mustBringOneBook(){
		Book book1 = given().header("Accept", "application/json").expect().statusCode(200).get("/book/1").andReturn().as(Book.class);
		assertEquals(book1.getTitle(), "Book - 1");
		assertEquals(book1.getAuthors().get(0).getNome(), "Rafael Macedo");
		assertEquals(book1.getAuthors().get(1).getNome(), "Amanda Macedo");
	}
	
	@Test
	public void mustBringTwoBooks(){
		
//		JsonPath path = given().header("Accept", "application/json").get("/book/author/Rafael").andReturn().jsonPath();
		
		Book[] list = given().header("Accept", "application/json").expect().statusCode(200).get("/book/author/Rafael").as(Book[].class);
		
		assertTrue("Book - 1".equals(list[0].getTitle()) );
		assertTrue("Book - 3".equals(list[1].getTitle()) );
	}
	
	@Test
	public void mustSaveOneBook(){
		Author rafael = new Author("Rafael Macedo");
		Book book = new Book(6L, "Book - 6", Arrays.asList(rafael));
		Response response = (Response) given().header("Accept", "application/json")
				.contentType("application/json").body(book).post("/inserir/livro").then().extract().response();
		
		assertEquals(response.getStatusCode(), 201);
	}

}
























