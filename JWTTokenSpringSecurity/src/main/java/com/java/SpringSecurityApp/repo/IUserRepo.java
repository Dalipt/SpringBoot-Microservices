package com.java.SpringSecurityApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringSecurityApp.entity.Users;

public interface IUserRepo extends JpaRepository<Users, String>
{
	Users findByName(String userName);
}
