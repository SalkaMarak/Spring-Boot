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

import com.excelr.entity.Department;
import com.excelr.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	
	//adding
	@PostMapping("/dept")
	public ResponseEntity<Department> add(@RequestBody Department dept){
		Department d =  deptService.insertDept(dept);
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	//fetching all departments
	@GetMapping("/allDept")
	public ResponseEntity<List<Department>> getAll(){
		List<Department> list = deptService.getAllDept();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	//fetching 
	@GetMapping("/dept/{id}")
	public ResponseEntity<Department> getById(@PathVariable int id){
		Department dep = deptService.getDept(id);
		return ResponseEntity.status(HttpStatus.OK).body(dep);
	}
	//update 
	@PutMapping("/dept/{id}")
	public ResponseEntity<Department> update(@PathVariable int id, @RequestBody Department updatedDept){
		Department d = deptService.updateDept(id, updatedDept);
		return ResponseEntity.status(HttpStatus.OK).body(d);
	}
	//delete
	@DeleteMapping("/dept/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		deptService.deleteDept(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully.");
	}
}
