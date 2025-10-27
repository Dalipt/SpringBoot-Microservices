package com.java.SpringRestApp.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringRestApp.Service.IGreeting;
import com.java.SpringRestApp.model.Student;

//@Controller+@ResponseBody=@RestController
@RestController
@RequestMapping("api1")
public class GreetingController 
{	
	@Autowired
	private IGreeting service;
	
	
	@GetMapping("/greet")
	@ResponseBody
	public ResponseEntity<String>getWishes()
	{
		String res=service.generateWish("Nandu");
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student data)
	{
		Boolean stst = service.addStudent(data);
		if(stst)
		{
			String msg="Student data added";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		else
		{
			String msg="Student data not got added";
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		
	}
}
