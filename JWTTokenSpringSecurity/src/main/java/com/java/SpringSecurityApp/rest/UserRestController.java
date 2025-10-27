package com.java.SpringSecurityApp.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringSecurityApp.entity.Users;
import com.java.SpringSecurityApp.model.Employee;
import com.java.SpringSecurityApp.service.JwtTokenService;
import com.java.SpringSecurityApp.service.UserService;

@RestController
public class UserRestController 
{

	@Autowired
	private UserService service;
	
	@Autowired
	private JwtTokenService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	BCryptPasswordEncoder bxc=new BCryptPasswordEncoder();
	
	@PostMapping("/add-users")
	public Users registerNewUser(@RequestBody Users user)
	{
		String str = bxc.encode(user.getPassword());
		user.setPassword(str);
		return service.register(user);
	}
	@PostMapping("/login")
	public String loginUser(@RequestBody Users user)
	{
	    Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
		if(auth.isAuthenticated())
		{	
		String jwt=jwtService.generateToken(user.getName());
		System.out.println(jwt);
		return jwt;
		}
		else
		{
			return "Invalid details";
		}
		}
	
	@GetMapping("/get-user")
	public String getAllUsers()
	{
		return "User is added";	
	}
}
