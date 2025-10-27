package com.java.JavaMicroservice2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CourseService
{
	
	@Autowired
	private CourseFeignClient feign;
	
	public String getCourseInfo()
	{
		/*
		 * RestTemplate rest= new RestTemplate(); ResponseEntity<String> response =
		 * rest.getForEntity("http://localhost:8080/get-course", String.class); return
		 * response.getBody()+ "Coming from Another Controller";
		 */
		
		ResponseEntity<String> response =feign.getCourseInfo();
		return response.getBody()+ "Coming from Another Controller";
	}
}
