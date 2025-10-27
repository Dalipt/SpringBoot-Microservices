package com.java.SpringBatchProcessing.config;

import org.springframework.batch.item.ItemProcessor;

import com.java.SpringBatchProcessing.model.Courses;

public class CoursesProcessor implements ItemProcessor<Courses, Courses>
{

	@Override
	public Courses process(Courses item) throws Exception {
		// login to process data//filter
		return item;
	}

}
