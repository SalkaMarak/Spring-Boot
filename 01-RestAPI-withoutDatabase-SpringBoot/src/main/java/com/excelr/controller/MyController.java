package com.excelr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Student;

@RestController
public class MyController 
{
	@GetMapping("/welcome")
	public String getData() {
		System.out.println("running api");
		return "This is my first rest API";
	}
	
	@GetMapping("/student")
	public Student getStudent() {
		Student stu = new Student(1, "aman", 67);
		return stu;
	}
//we get the output in JSON format:  {"sid":1,"sname":"aman","marks":67}

	//if we want to get multiple objects
	@GetMapping("/allStudent")
	public List<Student> getAllStudents(){
		List<Student> li = new ArrayList();
		Student stu1 = new Student(1, "aman", 67);
		Student stu2 = new Student(2, "sman", 77);
		Student stu3 = new Student(3, "taman", 88);
		Student stu4 = new Student(4, "yaman", 37);
		Student stu5 = new Student(5, "faman", 97);
		li.add(stu1);
		li.add(stu2);
		li.add(stu3);
		li.add(stu4);
		li.add(stu5);
		return li;
	}
	//[{"sid":1,"sname":"aman","marks":67},{"sid":2,"sname":"sman","marks":77},{"sid":3,"sname":"taman","marks":88},{"sid":4,"sname":"yaman","marks":37},{"sid":5,"sname":"faman","marks":97}]
	//we can call these restApi from any of the application react, angular any browser, postman, if we know the URL
}

//we acept the request process the req and send response in controller class
