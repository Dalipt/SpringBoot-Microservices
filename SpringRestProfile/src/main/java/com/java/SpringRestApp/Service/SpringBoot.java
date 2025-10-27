package com.java.SpringRestApp.Service;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("springboot")
public class SpringBoot implements  ICourse {

	public Boolean getTheCourse(Double amount) 
	{
		System.out.println("Course Purchase and amount paid is:"+amount);
		return true;
	}


}
