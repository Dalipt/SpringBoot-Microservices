package com.java.SpringMVCApp.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService implements IGreeting 
{
	@Autowired
	private LocalTime time;
	
	public String generateWish(String name)
	{
		int hour=time.getHour();
		if(hour>20)
			return "Good Morning!"+name;
		else if(hour>12)
			return"GoodEvening"+name;
		else
			return "GoodNigh!"+name;
	}

}
