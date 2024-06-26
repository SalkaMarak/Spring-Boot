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

import com.excelr.entity.Course;
import com.excelr.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<Course> addCourse(@RequestBody Course cs){
		Course c = courseService.insertCourse(cs);
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
	@GetMapping("/allCourses")
	public ResponseEntity<List<Course>> fetchAll(){
		List<Course> list = courseService.getAllCourses();
		return ResponseEntity.ok(list);
	}
	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> fetchCourse(@PathVariable int cid){
		Course c = courseService.getCourse(cid);
		return ResponseEntity.ok(c);
	}
	@PutMapping("/course/{cid}")
	public ResponseEntity<Course> updateCourse(@PathVariable int cid, @RequestBody Course updatedC){
		Course c = courseService.updateCrs(cid, updatedC);
		return ResponseEntity.ok(c);
	}
	@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteCourse(@PathVariable int cid){
		courseService.deleteCrs(cid);
		return ResponseEntity.ok("Course deleted successfully.");
	}	
}
