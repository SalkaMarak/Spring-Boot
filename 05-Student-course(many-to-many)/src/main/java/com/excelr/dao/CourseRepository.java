package com.excelr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
