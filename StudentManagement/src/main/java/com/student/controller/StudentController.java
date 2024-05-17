package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService stdservice;

	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome to Student Management";
	}
	
	@GetMapping("/findallstudent")
	public ResponseEntity<List<StudentDto>> getAllStudent(){
		return stdservice.findAllStudent();
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto stddto){		
		return stdservice.addStudent(stddto);
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto stddto){		
		return stdservice.updateStudent(stddto);
	}
	
	@GetMapping("/studentbyid/{stdid}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable int stdid){
		
		return stdservice.findStudentById(stdid);
		
	}
	@GetMapping("/studentbyname/{name}")
	public ResponseEntity<List<StudentDto>> getStudentByName(@PathVariable String name){
		return stdservice.findStudentByName(name);
	}
	
	@GetMapping("/studentbyclass/{cls}")
	public ResponseEntity<List<StudentDto>> getStudentByName(@PathVariable int cls){
		return stdservice.findStudentByClass(cls);
	}
	
	
}
