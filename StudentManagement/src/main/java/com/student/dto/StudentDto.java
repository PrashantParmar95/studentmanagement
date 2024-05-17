package com.student.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private int id;
	private String name;
	private int stdclass;
	private Date dob;	
	private Date joiningdate;

}
