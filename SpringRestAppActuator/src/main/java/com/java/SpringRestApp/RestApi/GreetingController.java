package com.java.SpringRestApp.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringRestApp.Service.IGreeting;

//@Controller+@ResponseBody=@RestController
@RestController
@RequestMapping("api1")
public class GreetingController 
{	
	@Autowired
	private IGreeting greeting;
	
	
	@GetMapping("/greet")
	@ResponseBody
	public ResponseEntity<String>getWishes()
	{
		String res=greeting.generateWish("nandu");
		return new ResponseEntity<String>(res,HttpStatus.OK);
		
	}
	
	@GetMapping("/greet1")
	public String getWishes1()
	{
		String str=greeting.generateWish("Kannu");
		return str; 
	}
}
