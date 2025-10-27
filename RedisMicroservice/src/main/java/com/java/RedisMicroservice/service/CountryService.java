package com.java.RedisMicroservice.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.java.RedisMicroservice.model.Country;

@Service
public class CountryService
{
	private HashOperations<String, Object,Object> opsForHash=null;
	public CountryService(RedisTemplate<String,Country> redis)
	{
		opsForHash=redis.opsForHash();
	}
	public String addCountry(Country country)
	{
		opsForHash.put("COUNTRIES", country.getNo(), country);
		return "Country Data Added in Reddis server";
	}
	
}
