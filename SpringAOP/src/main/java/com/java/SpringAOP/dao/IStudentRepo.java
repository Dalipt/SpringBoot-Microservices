package com.java.SpringAOP.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.SpringAOP.model.Student;

import jakarta.persistence.Id;
@Repository
public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
