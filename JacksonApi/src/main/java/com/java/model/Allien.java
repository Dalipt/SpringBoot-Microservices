package com.java.model;

import java.io.Serializable;

public class Allien implements Serializable
{
	private Integer Id;
	private String name;
	private String city;
	public Allien(Integer id, String name, String city) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Allien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Allien [Id=" + Id + ", name=" + name + ", city=" + city + "]";
	}
	
}
