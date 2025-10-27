package com.java.SpringHateoasApp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringHateoasApp.model.Course;

@RestController
public class CourseController
{
	@GetMapping("/course-info")
	public ResponseEntity<Course> getCourseInfo()
	{
		Course cs= new Course(1,"SpringBoot",2323.21);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder
				.methodOn(CourseController.class).getAllCourseInfo()).withRel("Get All CourseInfo");
		cs.add(link);
		return new ResponseEntity<Course>(cs,HttpStatus.OK);
	}
	@GetMapping("/all-course-info")
	public ResponseEntity<List> getAllCourseInfo()
	{
		Course cs= new Course(1,"SpringBoot",2323.21);
		Course cs1= new Course(2,"Spring",2453.21);
		Course cs2= new Course(3,"AWS",22434.21);
		
		List<Course> course= new ArrayList<>();
		course.add(cs);
		course.add(cs1);
		course.add(cs2);
		return new ResponseEntity<List>(course,HttpStatus.OK);
	}
}
