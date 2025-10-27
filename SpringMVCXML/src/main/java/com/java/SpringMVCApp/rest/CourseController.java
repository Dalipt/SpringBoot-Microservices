package com.java.SpringMVCApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringMVCApp.model.Course;

@RestController
public class CourseController 
{
	@PostMapping (value="/add-course", consumes={"application/xml","application/json"})
	public ResponseEntity<String> addCourseInfo(@RequestBody Course course)
	{
		System.out.println(course);
		String str="Course info is";
		return new ResponseEntity<String>(str,HttpStatus.CREATED);
	}
	
	@GetMapping (value="/get-course", produces={"application/xml","application/json"})
	public ResponseEntity<Course> getCourseInfo()
	{
		Course course= new Course(1,"DevOps","4 Months",999.9);
		System.out.println(course);
		return new ResponseEntity<Course>(course,HttpStatus.CREATED);
	}

}
