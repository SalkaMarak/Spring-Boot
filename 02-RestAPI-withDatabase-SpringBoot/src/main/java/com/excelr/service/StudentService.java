package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.StudentRepository;
import com.excelr.entity.Student;

@Service		
public class StudentService 
{
	@Autowired
	private StudentRepository stdRepo; 
	
	//adding
	public void addStudent(Student std)
	{
		stdRepo.save(std);
		System.out.println("student inserted successfully.");
	}
	
	//fetching all the students
	public List<Student> getAllStudents()
	{
		List<Student> list = stdRepo.findAll();
		return list;
	}
	
	//fetching single object
	public Student getStudent(int id) 
	{
		//stdRepo.findById(id).get(); //if we are getting returned Optional object there is a method to get that will give us actual Student obj (Java 8 feature)
		Optional<Student> op = stdRepo.findById(id);
		Student s1 = op.get();
		return s1;
	}
	
	//updating 
	public Student updateStudent(int id, Student updatedStd) 
	{
		//there is no direct method for updating, so get obj first
		Student oldStu = stdRepo.findById(id).get();
		if(updatedStd.getSname() != null) oldStu.setSname(updatedStd.getSname());
		if(updatedStd.getMarks() > 0) oldStu.setMarks(updatedStd.getMarks());
		
		return stdRepo.save(oldStu);
	}
	
	//deleting
	public void deleteStudent(int id) 
	{
		Student stu_to_delete = stdRepo.findById(id).get();
		stdRepo.delete(stu_to_delete);
		
		//stdRepo.deleteById(id); or this
	}
}

//@Service	-to make it service layer
//we don't have to create an object or implement the spring container will do it for us by using @autowired.
//findById returns Optional<T> type.