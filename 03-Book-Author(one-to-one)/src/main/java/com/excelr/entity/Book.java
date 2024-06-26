package com.excelr.entity;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //like auto increment
	private int bid;
	private String title;
	@OneToOne
	@Cascade(org.hibernate.annotations.CascadeType.ALL) //first we have to add parent objects then only we can add to child.
	@JsonManagedReference				//so we say this is parent
	private Author author;
	
	public Book() {
	}
	
	public Book(int bid, String title, Author author) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	//first we have to add parent objects then only we can add to child.
	//similarly while deleting we have to delete the child and then parent.
}
