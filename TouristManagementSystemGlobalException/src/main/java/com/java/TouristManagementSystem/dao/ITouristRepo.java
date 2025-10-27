package com.java.TouristManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.TouristManagementSystem.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
