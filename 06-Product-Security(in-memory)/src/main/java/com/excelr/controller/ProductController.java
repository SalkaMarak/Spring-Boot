package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Product;
import com.excelr.entity.UserInfo;
import com.excelr.service.ProductService;
import com.excelr.service.UserInfoService;

@RequestMapping("/product")
@RestController
public class ProductController {
	@Autowired
	ProductService pService;
	@Autowired
	private UserInfoService userService;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.status(HttpStatus.OK).body("Welcome to my site");
	}
	@PostMapping
	public ResponseEntity<Product> postMethodName(@RequestBody Product p) {
		Product pd = pService.insertProduct(p);
		return ResponseEntity.ok(pd);
	}
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAll(){
		List<Product> li = pService.getAllProduct();
		return ResponseEntity.ok(li);
	}
	@GetMapping("/{id}")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public ResponseEntity<Product> getId(@PathVariable int id){
		Product p = pService.getProduct(id);
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product up){
		Product p = pService.updateProduct(id, up);
		return ResponseEntity.ok(p);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		String s = pService.deleteProduct(id);
		return ResponseEntity.ok(s);
	}
	
	//adding a userInfo
	@PostMapping("/new")
	public String addUserInfo(@RequestBody UserInfo u) {
		return userService.insertUserInfo(u);
	}
	/*
	{
    "name":"salka",
    "password":"admin",
    "email":"salka@gmail.com",
    "role":"ROLE_ADMIN" or ROLE_USER
    }*/
}
