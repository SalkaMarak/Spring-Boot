package com.excelr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.dao.EmployeeRepository;
import com.excelr.dto.EmpDeptDto;
import com.excelr.entity.Department;
import com.excelr.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;
	
	//adding employee
	public Employee insertEmp(Employee emp) {
		return empRepo.save(emp);
	}
	//get all data
	public List<EmpDeptDto> getAllEmp(){
		List<Employee> list = empRepo.findAll();
		List<EmpDeptDto> returnList = new ArrayList();
		
		for(Employee e : list) {
			EmpDeptDto dto = new EmpDeptDto();
			dto.setEmpId(e.getEid());
			dto.setEmpName(e.getEmpName());
			Department d = e.getDepartment();
			dto.setDeptId(d.getDeptId());
			dto.setDeptName(d.getDeptName());
			returnList.add(dto);
		}
		return returnList;
	}
	//get single employee
	public EmpDeptDto getById(int id) {
		Employee e = empRepo.findById(id).get();
		Department d = e.getDepartment();
		
		EmpDeptDto dto = new EmpDeptDto();
		
		dto.setEmpId(e.getEid());
		dto.setEmpName(e.getEmpName());
		dto.setDeptId(d.getDeptId());
		dto.setDeptName(d.getDeptName());
		
		return dto;
	}
	//update
	public Employee updateEmp(int id, Employee updatedEmp) {
		Employee oldEmp = empRepo.findById(id).get();
		if(updatedEmp.getEmpName() != null) oldEmp.setEmpName(updatedEmp.getEmpName());
		return empRepo.save(oldEmp);
	}
	//delete 
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}
