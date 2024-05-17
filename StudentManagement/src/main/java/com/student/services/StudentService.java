package com.student.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.student.dto.StudentDto;

public interface StudentService {
	
	public ResponseEntity<List<StudentDto>> findAllStudent();

	public ResponseEntity<StudentDto> addStudent(StudentDto stddto);

	public ResponseEntity<StudentDto> findStudentById(int stdid);

	public ResponseEntity<List<StudentDto>> findStudentByName(String name);

	public ResponseEntity<List<StudentDto>> findStudentByClass(int cls);

	public ResponseEntity<StudentDto> updateStudent(StudentDto stddto);

}
