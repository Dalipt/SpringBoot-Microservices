package com.java.RedisMicroservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.RedisMicroservice.model.Country;
import com.java.RedisMicroservice.service.CountryService;

@RestController
public class CountryController 
{
	@Autowired
	private CountryService service;
	
	@PostMapping("/addCountry")
	public String addCountry(@RequestBody Country country)
	{
		return service.addCountry(country);
	}
	
}
