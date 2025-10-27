package com.java.TouristManagementSystem.rest;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TouristRestApi 
{
	@Autowired
	public ITouristService service;
	@PostMapping("/regtourist")
	public ResponseEntity<Integer> registerTourist(@RequestBody Tourist tourist)
	{
		Integer ser= service.registerTourist(tourist);
		return new ResponseEntity<Integer>(ser,HttpStatus.CREATED);
	}
	
	@PostMapping("/regtourist/{id}")
	public ResponseEntity<Tourist> registerTourist(@PathVariable("id") Integer id)
	{
		Tourist ser= service.fetchTouristById(id);
		return new ResponseEntity<Tourist>(ser,HttpStatus.OK);
	}
	@PostMapping("/getalltourist")
	public ResponseEntity<?> getAllTourist()
	{
		List<Tourist> ser= service.fetchAllTouristInfo();
		return new ResponseEntity<List>(ser,HttpStatus.OK);	
	}
	  @PutMapping("/updatetourist") 
	  public ResponseEntity<?>updateTheTourist(@RequestBody Tourist tourist) 
	  {
			  String ser=service.updateTouristInfo(tourist);
			  return new ResponseEntity<String>(ser,HttpStatus.OK);
	  } 
	@PatchMapping("/updatetouristbudget/{id}/{budget}")
	public ResponseEntity<?> updateTouristBudget(@PathVariable("id") Integer id,@PathVariable("budget") Double budget)
	{
		String ser=service.updateTouristBudget(id, budget);
		return new ResponseEntity<String>(ser,HttpStatus.OK);
	}
	@DeleteMapping("/deletetourist/{id}")
	public ResponseEntity<?>deleteTouristBasedOnId(@PathVariable("id") Integer id)
	{
		String ser=service.deleteTouristBasedOnId(id);
		return new ResponseEntity<String>(ser,HttpStatus.OK);
	}
}