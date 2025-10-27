package com.java.SpringMvcApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController 
{
	@RequestMapping("/welcome")
	public ModelAndView displayMessage()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("message", "Hello I just resolve it");
		mv.setViewName("index");
		
		return mv;
	}
	@GetMapping("/welcome2")
	public ModelAndView displayMessage2()
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("message", "This is request mapping issue");
		mv.setViewName("index");
		
		return mv;
	}
}
