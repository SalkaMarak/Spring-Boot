package com.excelr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String empName;
	@ManyToOne
	@JoinColumn(name = "depId")
	@JsonBackReference		//on child. but this is needed for updation so use this 
	//@JsonIgnoreProperties("employee")
	private Department department;
	//this will create another column department_deptId (name long so we rename)
	
	public Employee() {
	}
	
	public Employee(int eid, String empName, Department department) {
		super();
		this.eid = eid;
		this.empName = empName;
		this.department = department;
	}

	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
//@JsonIgnoreProperties("employee") shows the detail of dependent property
//@JsonBackReference completely skips the whole detail of this
//@JoinTable is used to rename col name
//we want the oneToMany side to make the mapping not manyToone side because that will create new table
