package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.CourseRepository;
import com.excelr.entity.Course;

import jakarta.transaction.Transactional;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepo;
	
	//adding a course
	public Course insertCourse(Course c) {
		return courseRepo.save(c);
	}
	//fetching all courses
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	//fetch single course
	public Course getCourse(int id) {
		return courseRepo.findById(id).get();
	}
	//update
	public Course updateCrs(int id, Course updatedC) {
		Course c = courseRepo.findById(id).get();
		if(updatedC.getCname() != null) c.setCname(updatedC.getCname());
		return courseRepo.save(c);
	}
	public void deleteCrs(int cid) {
		Course c1 = courseRepo.findById(cid).get();
		c1.setStudents(null);
		courseRepo.save(c1);
		courseRepo.deleteById(cid);	
	}
}
