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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Student;
import com.excelr.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student stu) {
		Student s = studentService.insertStudent(stu);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	//enrolling student with course
	//http://localhost:8080/enroll?sid=1&cid=1
	@PostMapping("/enroll")
	public ResponseEntity<Student> enroll(@RequestParam int sid, @RequestParam int cid){
		Student stu = studentService.enrollStd(sid, cid);
		return ResponseEntity.status(HttpStatus.OK).body(stu);
	}
	@GetMapping("/allStudents")
	public ResponseEntity<List<Student>> getAll(){
		List<Student> list = studentService.getAllStd();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/student/{sid}")
	public ResponseEntity<Student> getStudent(@PathVariable int sid){
		Student s = studentService.getStd(sid);
		return ResponseEntity.ok(s);
	}
	@PutMapping("/student/{sid}")
	public ResponseEntity<Student> updateStudent(@PathVariable int sid, @RequestBody Student updatedS){
		Student s = studentService.updateStd(sid, updatedS);
		return ResponseEntity.ok(s);
	}
	@DeleteMapping("/student/{sid}")
	public ResponseEntity<String> deleteStudent(@PathVariable int sid){
		studentService.deleteStd(sid);
		return ResponseEntity.ok("Student deleted successfully.");
	}
}
//student/{sid}/enroll/course/{cid} for this type use @Request body.
