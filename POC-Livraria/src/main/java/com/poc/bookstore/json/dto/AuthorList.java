package com.poc.bookstore.json.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorList {
	
	List<Author> authors = new ArrayList<Author>();
	
	public AuthorList(List<Author> authors) {
		this.authors = authors;
	}

	public AuthorList() {	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	
	

}
