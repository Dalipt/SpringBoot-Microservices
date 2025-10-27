package com.java.SpringRestApp.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service

public class Java implements ICourse {


	public Boolean getTheCourse(Double amount)
	{
		System.out.println("java Course opt and amount paid is:"+amount);
		return true;
	}

}
