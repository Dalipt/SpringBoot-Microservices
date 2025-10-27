package com.java.SpringMVCApp.config;

import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class DateTimeConfig 
{
	@Bean
	public LocalTime generateTime()
	{
		return LocalTime.now();
	}
}
