package com.java.SpringRestApp.Service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.SpringRestApp.model.Student;

@Service
public class GreetingService implements IGreeting 
{
	
	public String generateWish(String name)
	{
		LocalTime time=LocalTime.now();
		int hour=time.getHour();
		if(hour>20)
			return "Good Morning!" +name;
		else if(hour>12)
			return"GoodEvening"+ name;
		else
			return "GoodNigh!"+ name;
	}

	@Override
	public Boolean addStudent(Student st) {
		System.out.println(st);
		return true;
	}

}
