package com.java.SpringMVCApp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController 
{
	@GetMapping("/home")
	public String showHomePage()
	{
		return "home";
	}
	@GetMapping("/response")
	public String getBookInfo(Map<String, Object>map)
	{
		String book[]=new String[] {"Java","JDBC","Spring"};
		for(String booksName:book)
		{
			System.out.println(booksName);
		}
		map.put("booksName", book);
		return "response";
	}
}
