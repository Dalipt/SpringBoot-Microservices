package com.java.SpringMVCApp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.SpringMVCApp.model.Employee;

@Controller
public class EmployeeController 
{
	@GetMapping("/register")
	public String getHomePage()
	{
		return "register";
	}
	@PostMapping("/register")
	public String register(Map<String,Object>map,Employee emp)
	{
		System.out.println(emp);
		map.put("emp", emp);
		return "response";
	}
}
