package com.java.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.SpringSecurityApp.entity.Users;
import com.java.SpringSecurityApp.repo.IUserRepo;
@Service
public class UserService
{
	
	@Autowired
	public IUserRepo repo;
	
	public Users register(Users user)
	{
		return repo.save(user);
	}

}
