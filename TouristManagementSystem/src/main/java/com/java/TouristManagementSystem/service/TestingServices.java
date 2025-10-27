package com.java.TouristManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingServices
{
	@Autowired
	public ITouristService service;
	
	public TestingServices()
	{
		System.out.println("TestingServices beans created");
	}
}
