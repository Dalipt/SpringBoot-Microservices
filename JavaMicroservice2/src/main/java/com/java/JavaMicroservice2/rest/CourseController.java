package com.java.JavaMicroservice2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController
{
	@Autowired
	private com.java.JavaMicroservice2.service.CourseService service;
	
	@GetMapping("/course-Details")
	public ResponseEntity<String> getCourseInfo()
	{
		String info=service.getCourseInfo();
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}
}
