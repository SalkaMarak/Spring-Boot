package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.BookRepository;
import com.excelr.entity.Book;

@Service
public class BookService 
{
	@Autowired
	private BookRepository bookRepo;
	
	//adding
	public Book insertBook(Book book) 
	{
		Book b = bookRepo.save(book);
		return b;
	}
	//get all
	public List<Book> getAllBooks() 
	{
		return bookRepo.findAll();
	}
	//get by id
	public Book getById(int id) 
	{
		return bookRepo.findById(id).get();
	}
	//updating
	public Book updateBook(int id, Book updatedBook)
	{
		Book oldBook = bookRepo.findById(id).get();
		if(updatedBook.getTitle() != null) oldBook.setTitle(updatedBook.getTitle());
		if(updatedBook.getAuthor() != null) oldBook.setAuthor(updatedBook.getAuthor());
		return bookRepo.save(oldBook);
	} //when we do update in bidirectional we have to supply the ids of both.
	//delete
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
}
