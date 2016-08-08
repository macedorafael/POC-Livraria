package com.poc.bookstore.json.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Author {

	private Long id;
	private String nome;
	
	Author() {}
	
	public Author(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
