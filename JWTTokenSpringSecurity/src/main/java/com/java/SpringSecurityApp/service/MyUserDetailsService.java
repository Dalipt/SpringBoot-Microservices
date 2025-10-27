package com.java.SpringSecurityApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.SpringSecurityApp.entity.Users;
import com.java.SpringSecurityApp.repo.IUserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	public IUserRepo repo;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=repo.findByName(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrinciple(user);
	}

}
