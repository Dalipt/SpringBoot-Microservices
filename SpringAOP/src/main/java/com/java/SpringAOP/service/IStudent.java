package com.java.SpringAOP.service;

import java.util.List;

import com.java.SpringAOP.model.Student;

public interface IStudent 
{
	public Student registerStudent(Student student);
	public List<Student> getAllStudent();
	
}
