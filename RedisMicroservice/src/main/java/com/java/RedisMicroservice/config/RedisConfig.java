package com.java.RedisMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.java.RedisMicroservice.model.Country;

@Configuration
public class RedisConfig 
{
	//1.Jeddis Connection factory
	@Bean
	public JedisConnectionFactory jeddisConnection()
	{
		JedisConnectionFactory jdfactory=new JedisConnectionFactory();
		return jdfactory;
	}
	//redisTemplate
	@Bean
	public RedisTemplate<String, Country> redisTemplate()
	{
		RedisTemplate<String, Country> redistemplate= new RedisTemplate<>();
		redistemplate.setConnectionFactory(jeddisConnection());
		return redistemplate;
	}
	
}
