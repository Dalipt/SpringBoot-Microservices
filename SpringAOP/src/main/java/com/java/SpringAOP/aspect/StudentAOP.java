package com.java.SpringAOP.aspect;

import java.time.LocalTime;

import org.aopalliance.intercept.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAOP
{
	@Before(value="execution(* com.java.SpringAOP.rest.*.*(..))")
	public void beforeAdvice(JoinPoint joinpoint)
	{
		System.out.println("Request Made to Main Contoller"+ joinpoint.getClass()+LocalTime.now() );
	}

	@Before(value="execution(* com.java.SpringAOP.service.IStudentImplements.*(..))")
	public void beforeAdviceService(JoinPoint joinpoint)
	{
		System.out.println("Request Made to Service Controller"+ joinpoint.getClass()+LocalTime.now() );
	}
	
	@After(value="execution(* com.java.SpringAOP.service.IStudentImplements.*(..))")
	public void afterAdviceService(JoinPoint joinpoint)
	{
		System.out.println("Request Made to after service Controller"+ joinpoint.getClass()+LocalTime.now() );
	}
}
