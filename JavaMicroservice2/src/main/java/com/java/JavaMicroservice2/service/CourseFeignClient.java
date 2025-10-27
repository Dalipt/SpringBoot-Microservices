package com.java.JavaMicroservice2.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="JavaMicroservice1")
public interface CourseFeignClient 
{
	@GetMapping("/get-course")
	public ResponseEntity<String> getCourseInfo();
}
