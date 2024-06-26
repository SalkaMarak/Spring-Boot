package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Book;
import com.excelr.service.BookService;

@RestController
public class BookController 
{
	@Autowired
	BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<Book> add(@RequestBody Book book) {
		Book b = bookService.insertBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body(b); 
		//in the response body we are sending the message along w object
	}
	//fetch all
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getAll(){
		List<Book> list = bookService.getAllBooks();
		return ResponseEntity.status(HttpStatus.FOUND).body(list);
	}
	//fetching single record
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getId(@PathVariable int id){
		Book book = bookService.getById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(book);
	}
	//update record
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book){
		Book b = bookService.updateBook(id, book);
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	@DeleteMapping("/book/{id}")
	public void delete(@PathVariable int id) {
		bookService.deleteBook(id);
	}
}

//500 server 404 bad request 200 success