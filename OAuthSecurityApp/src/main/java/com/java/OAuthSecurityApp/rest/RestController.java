package com.java.OAuthSecurityApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController 
{

	@GetMapping("/info")
	public String getCourseInfo()
	{
		
		return "I'm trying OAuthSecurity";
	}
}
