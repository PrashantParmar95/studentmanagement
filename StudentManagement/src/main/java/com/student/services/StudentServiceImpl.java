package com.student.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.student.dto.StudentDto;
import com.student.entities.Student;
import com.student.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo stdrepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseEntity<List<StudentDto>> findAllStudent() {
		List<Student> studentlist = stdrepo.findAll();
		List<StudentDto> studentstolist = studentlist.stream().map(std -> mapper.map(std, StudentDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity(studentstolist, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentDto> addStudent(StudentDto stddto) {
		Student student = stdrepo.save(mapper.map(stddto, Student.class));
		return new ResponseEntity(mapper.map(student, StudentDto.class), HttpStatus.CREATED);
	}
	
	@Override
	public ResponseEntity<StudentDto> updateStudent(StudentDto stddto) {
		Student student = stdrepo.save(mapper.map(stddto, Student.class));
		return new ResponseEntity(mapper.map(student, StudentDto.class), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<StudentDto> findStudentById(int stdid) {

		Student student = stdrepo.findById(stdid).get();
		StudentDto stddto = mapper.map(student, StudentDto.class);
		return new ResponseEntity(stddto, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<StudentDto>> findStudentByName(String name) {

		List<Student> studentlist = stdrepo.findByName(name);
		List<StudentDto> studentstolist = studentlist.stream().map(std -> mapper.map(std, StudentDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity(studentstolist, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<StudentDto>> findStudentByClass(int cls) {
		List<Student> studentlist = stdrepo.findByStdclass(cls);
		List<StudentDto> studentstolist = studentlist.stream().map(std -> mapper.map(std, StudentDto.class))
				.collect(Collectors.toList());
		return new ResponseEntity(studentstolist, HttpStatus.OK);
	}

	

}
