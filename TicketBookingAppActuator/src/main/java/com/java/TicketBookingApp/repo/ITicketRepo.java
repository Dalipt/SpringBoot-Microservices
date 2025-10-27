package com.java.TicketBookingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.TicketBookingApp.model.Passenger;

public interface ITicketRepo extends JpaRepository<Passenger, Integer> {

}
