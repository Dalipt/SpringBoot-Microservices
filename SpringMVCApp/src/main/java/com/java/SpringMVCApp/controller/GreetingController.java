package com.java.SpringMVCApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.SpringMVCApp.service.IGreeting;




@Controller
public class GreetingController
{
	@Autowired
	private IGreeting greet;
	
	@GetMapping("/greet")
	public String generateWish(Model model)
	{
		String info=greet.generateWish("Rajesh");
		model.addAttribute("wish", info);
		return "greeting"; 
	}
}
