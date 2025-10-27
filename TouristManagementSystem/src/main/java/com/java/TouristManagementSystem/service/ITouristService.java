package com.java.TouristManagementSystem.service;

import java.util.List;

import com.java.TouristManagementSystem.exception.TouristNotFoundException;
import com.java.TouristManagementSystem.model.Tourist;

public interface ITouristService 
{
	Integer registerTourist(Tourist tourist);
	Tourist fetchTouristById(Integer Id) throws TouristNotFoundException;
	List<Tourist> fetchAllTouristInfo();
	String updateTouristInfo(Tourist tourist);
	String updateTouristBudget(Integer id, Double budget);
	String deleteTouristBasedOnId(Integer id);
}
