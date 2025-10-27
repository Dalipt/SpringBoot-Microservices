package com.java.TouristManagementSystem.rest;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.TouristManagementSystem.exception.TouristNotFoundException;
import com.java.TouristManagementSystem.model.Tourist;
import com.java.TouristManagementSystem.service.ITouristService;

@RestController
@Scope("session")
public class TouristRestApi 
{
	@Autowired
	public ITouristService service;
	
	public TouristRestApi()
	{
		System.out.println("TouristRestApi Bean");
	}
	
	@PostMapping("/regtourist")
	public ResponseEntity<Integer> registerTourist(@RequestBody Tourist tourist)
	{
		Integer ser= service.registerTourist(tourist);
		return new ResponseEntity<Integer>(ser,HttpStatus.CREATED);
	}
	
	@PostMapping("/regtourist/{id}")
	public ResponseEntity<?> registerTourist(@PathVariable("id") Integer id)
	{
		try
		{
		Tourist ser= service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(ser,HttpStatus.OK);
		}
		catch(TouristNotFoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/getalltourist")
	public ResponseEntity<?> getAllTourist()
	{
		try
		{
		List<Tourist> ser= service.fetchAllTouristInfo();
		return new ResponseEntity<List>(ser,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Some server erros",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	  @PutMapping("/updatetourist") 
	  public ResponseEntity<?>updateTheTourist(@RequestBody Tourist tourist) 
	  {
		  try 
	  { 
			  String ser=service.updateTouristInfo(tourist);
			  return new ResponseEntity<String>(ser,HttpStatus.OK);
			  } 
		 catch(Exception e)
		  { 
			 return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 
			 } } 
	@PatchMapping("/updatetouristbudget/{id}/{budget}")
	public ResponseEntity<?> updateTouristBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget)
	{
		try
		{
		String ser=service.updateTouristBudget(id, budget);
		return new ResponseEntity<String>(ser,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deletetourist/{id}")
	public ResponseEntity<?>deleteTouristBasedOnId(@PathVariable("id") Integer id)
	{
		try
		{
		String ser=service.deleteTouristBasedOnId(id);
		return new ResponseEntity<String>(ser,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	}
