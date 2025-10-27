package com.java.SpringRestApp.Service;

import com.java.SpringRestApp.model.Student;

public interface IGreeting {
	
	String generateWish(String name); 
	Boolean addStudent(Student st);

}
