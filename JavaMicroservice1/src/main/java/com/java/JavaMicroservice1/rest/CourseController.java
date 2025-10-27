package com.java.JavaMicroservice1.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController
{	
	@GetMapping("/get-course")
	public ResponseEntity<String> getCourseInfo()
	{
		String info="Course is selected to ace SpringBoot Micorservice";
		return new ResponseEntity<String>(info,HttpStatus.OK);
	}
}
