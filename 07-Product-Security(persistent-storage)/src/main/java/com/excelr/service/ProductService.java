package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.ProductRepository;
import com.excelr.entity.Product;

@Service
public class ProductService {
	@Autowired
	ProductRepository pRepo;
	
	//insert
	public Product insertProduct(Product p) {
		return pRepo.save(p);
	}
	//getAll
	public List<Product> getAllProduct(){
		return pRepo.findAll();
	}
	//getSingle
	public Product getProduct(int id) {
		return pRepo.findById(id).get();
	}
	//update
	public Product updateProduct(int id, Product updatedP) {
		Product p = pRepo.findById(id).orElse(null);
		if(p != null) {
			if(updatedP.getPname() != null) p.setPname(updatedP.getPname()); //3
			if(updatedP.getPrice() != 0) p.setPrice(updatedP.getPrice()); //2
			return pRepo.save(p);
		} 
		return null;
	}
	//delete
	public String deleteProduct(int id) {
		pRepo.deleteById(id);
		return "Deleted Successfully.";
	}
}
