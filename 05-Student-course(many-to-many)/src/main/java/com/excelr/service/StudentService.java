package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.CourseRepository;
import com.excelr.dao.StudentRepository;
import com.excelr.entity.Course;
import com.excelr.entity.Student;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;
	
	//adding student
	public Student insertStudent(Student std) {
		return studentRepo.save(std);
	}
	//enroll student for a course
	public Student enrollStd(int sid, int cid) {
		Student stu = studentRepo.findById(sid).orElseThrow(() -> new RuntimeException("Student not found"));
		Course crs = courseRepo.findById(cid).orElseThrow(() -> new RuntimeException("Course not found"));
		//we will get empty arrayList then .add crs
		stu.getCourses().add(crs);

		return studentRepo.save(stu);
	}
	//fetch all students
	public List<Student> getAllStd(){
		return studentRepo.findAll();
	}
	//fetching single student
	public Student getStd(int id) {
		return studentRepo.findById(id).get();
	}
	//update
	public Student updateStd(int id, Student updatedStu) {
		Student stu = studentRepo.findById(id).get();
		if(updatedStu.getSname() != null) stu.setSname(updatedStu.getSname());
		return studentRepo.save(stu);
	}
	//delete
	public void deleteStd(int sid) {
		Student s1 = studentRepo.findById(sid).get();
		s1.setCourses(null);
		Student std = studentRepo.save(s1);
		studentRepo.deleteById(sid);
	}
}
