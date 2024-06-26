package com.excelr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.excelr.entity.Student;

//@Repository (optional)							<entity, primary key type>
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
}
//if we want use the abstract methods from JpaRepo we have to implement them, but we do not have to implement here as spring container will only do it.
//there will be save() method here implemented implicitly by the spring container so we can call it directly in the service class/layer.