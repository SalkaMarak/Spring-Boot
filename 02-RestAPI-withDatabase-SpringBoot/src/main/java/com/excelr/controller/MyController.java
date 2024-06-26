package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Student;
import com.excelr.service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyController 
{
	@Autowired
	private StudentService stdService;
	
	//adding
	@PostMapping("/insert")
	public String createStd(@RequestBody Student std) 
	{
		System.out.println(std);
		stdService.addStudent(std); //we use this send it to repoLayer to add
		return "added successfully";
	}
	
	//fetching all data
//	@GetMapping("/allStudents")
//	public List<Student> getAll() 
//	{
//		return stdService.getAllStudents();	
//	}
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list = stdService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	//fetching single object
	@GetMapping("/student/{id}") //id comes as a value so we get it like this
	public Student get(@PathVariable int id) 
	{
		return stdService.getStudent(id);
	}
	
	//updating Student
	@PutMapping("/student/{sid}")
	public Student update(@PathVariable int sid, @RequestBody Student std)
	{
		return stdService.updateStudent(sid, std);
	}
	
	//delete
	@DeleteMapping("/student/{sid}")
	public void delete(@PathVariable int sid) {
		stdService.deleteStudent(sid);
	}
}

//Dao ->(is dependent) service layer -> controller layer
//postMapping so we update in database

//@RequestBody Student std using this requestbody we have to collect the object and store it in std variable that is of type Student