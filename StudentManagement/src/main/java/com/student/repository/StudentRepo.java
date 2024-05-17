package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.student.entities.Student;

@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
	public List<Student> findByName(String name);
	public List<Student> findByStdclass(int name);

}
