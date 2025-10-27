package com.java.SpringSecurityApp.rest;
import java.awt.AWTException;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringSecurityApp.model.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@RestController
public class EmployeeController
{
	List <Employee> emp= new ArrayList<>(List.of(new Employee(1,"Dalip","Chandigarh",3213.45), new Employee(2,"Nandu","Mohali",54242.43), new Employee(3,"Kannu","Mohali",4424.32)));
	
	@GetMapping("/get-empl")
	public List<Employee> getAllEmployee()
	{
		return emp;	
	}
	@PostMapping("/add-employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
	    emp.add(employee);
	    System.out.println(emp);
	    return new ResponseEntity<>("Employee added successfully", HttpStatus.CREATED);
	}
	/*
	 * @PostMapping("/add-employee") public void addEmployee(@RequestBody Employee
	 * employee) { emp.add(employee); System.out.println(emp); }
	 */
	@GetMapping("/getinfo-empl")
	public String getemployee(HttpServletRequest request)
	{
		return "Number of employee add as" + request.getSession().getId();
	}
	
	@GetMapping("/getmoreinfo-empl")
	public String getmoreemployee(HttpServletRequest request)
	{
		return "Number employee plus session id" + request.getSession().getId();
	}
	@GetMapping("/moreinfo-empl")
	public CsrfToken getCsrfToken(HttpSession session)
	{
		System.out.println("before session token");
		return (CsrfToken) session.getAttribute("/moreinfo-empl");
		
	}
}

