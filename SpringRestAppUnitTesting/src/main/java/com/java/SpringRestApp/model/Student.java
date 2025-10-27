package com.java.SpringRestApp.model;

public class Student
{
	private Integer Id;
	private String name;
	private String city;
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
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", city=" + city + "]";
	}
	public Student(Integer id, String name, String city) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
	}
	
}
