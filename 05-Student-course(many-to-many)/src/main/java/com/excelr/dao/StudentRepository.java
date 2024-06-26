package com.excelr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
