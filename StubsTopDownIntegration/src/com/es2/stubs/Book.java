package com.es2.stubs;

public class Book {
	private String title;
	private String author;
	private String isbn;	
	
	public Book(String title, String author, String isbn) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getTitle() {
		return title;
	}
	
	
}
