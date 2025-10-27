package com.java.SpringAOP.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringAOP.model.Student;
import com.java.SpringAOP.service.IStudentImplements;

@RestController
public class StudentRestController
{
	@Autowired
	private IStudentImplements service;
	
	@PostMapping("/add-student")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student)
	{
		//Student st= new Student(1,"Kalu","Mohali",6757.8);
		Student st = service.registerStudent(student);
		return new ResponseEntity<Student>(st,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll-student")
	public ResponseEntity<List> getAllStudent()
	{
		List<Student> stt = service.getAllStudent();
		return new ResponseEntity<List>(stt,HttpStatus.OK);
		
	}
	
}
