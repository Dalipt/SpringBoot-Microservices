package com.java.SpringBatchProcessing.dao;

import org.springframework.batch.core.repository.JobRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.SpringBatchProcessing.model.Courses;

public interface ICourse extends JpaRepository<Courses, Integer>
{

}
