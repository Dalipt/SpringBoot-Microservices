package com.java.SpringMVCApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.SpringMVCApp.model.Course;

@Controller
public class CourseController
{
	@GetMapping("/courseinfo")
	public String getCourseInfo(Model model)
	{
		model.addAttribute("cid", "1");
		model.addAttribute("cname", "Testing");
		model.addAttribute("price", "10000INR");
		return "course";
	}
	
	@GetMapping("/coursedetail")
	public String getCourseDetails(Model model)
	{
		Course cs= new Course();
		cs.setCid(2);
		cs.setCname("DevOps");
		cs.setPrice(3424.3);
		model.addAttribute("course", cs);
		return "courseinfo";
	}
}
