package com.java.SpringAOP.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.java.SpringAOP.dao.IStudentRepo;
import com.java.SpringAOP.model.Student;

import jakarta.persistence.Id;

@Service
public class IStudentImplements implements IStudent 
{
	
	@Autowired
	private IStudentRepo repo;
	
	@Override
	public Student registerStudent(Student student)
	{
		
		return repo.save(student);
	}

	@Override
	public List<Student> getAllStudent() 
	{
		return repo.findAll();
	}

}