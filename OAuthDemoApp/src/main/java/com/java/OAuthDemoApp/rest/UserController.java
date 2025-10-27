package com.java.OAuthDemoApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController 
{
	@GetMapping("/get-course")
	public ResponseEntity<String> getResponseEntity()
	{
		String res="I'm a senior Java developer";
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
}
