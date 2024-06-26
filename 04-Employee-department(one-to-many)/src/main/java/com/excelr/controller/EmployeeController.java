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

import com.excelr.dto.EmpDeptDto;
import com.excelr.entity.Employee;
import com.excelr.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	//adding
	@PostMapping("/emp")
	public ResponseEntity<Employee> add(@RequestBody Employee emp){
		Employee e =   empService.insertEmp(emp);
		return ResponseEntity.status(HttpStatus.CREATED).body(e);
	}
	//fetching all departments
	@GetMapping("/allEmp")
	public ResponseEntity<List<EmpDeptDto>> getAll(){
		List<EmpDeptDto> list = empService.getAllEmp();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	//get single emp
	@GetMapping("/emp/{someId}")
	public ResponseEntity<EmpDeptDto> getId(@PathVariable(name="someId") int id){
		EmpDeptDto emp = empService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	//update
	@PutMapping("/emp/{someId}")
	public ResponseEntity<Employee> updateId(@PathVariable(name="someId") int id,@RequestBody Employee updatedEmp){
		Employee emp = empService.updateEmp(id, updatedEmp);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}
	//delete
	@DeleteMapping("emp/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		empService.deleteEmp(id);
		return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted.");
	}
}
