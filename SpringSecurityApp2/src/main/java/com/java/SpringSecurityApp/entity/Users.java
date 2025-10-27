package com.java.SpringSecurityApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USER")
public class Users 
{
	@Id
	private String name;
	private String password;
	
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password + "]";
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
