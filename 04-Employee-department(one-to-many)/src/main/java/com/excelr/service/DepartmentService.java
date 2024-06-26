package com.excelr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.DepartmentRepository;
import com.excelr.entity.Department;

@Service
public class DepartmentService 
{
	@Autowired
	private DepartmentRepository deptRepo;
	
	//adding department
	public Department insertDept(Department dept) {
		return deptRepo.save(dept);
	}
	//get all data
	public List<Department> getAllDept(){
		return deptRepo.findAll();
	}
	//get dept by id
	public Department getDept(int deptId) {
		return deptRepo.findById(deptId).get();
	}
	//update
	public Department updateDept(int id, Department updatedDept) {
		Department old = deptRepo.findById(id).get();
		if(updatedDept.getDeptName() != null ) old.setDeptName(updatedDept.getDeptName());
		if(updatedDept.getEmployee() != null)  old.setEmployee(updatedDept.getEmployee());
		return deptRepo.save(old);
	}
	//deleting
	public void deleteDept(int id) {
		deptRepo.deleteById(id);
	}
}
