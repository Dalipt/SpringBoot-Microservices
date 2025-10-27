package com.java.TicketBookingApp.service;

import com.java.TicketBookingApp.model.Passenger;

public interface ITicketService 
{
	Passenger registerPassanger(Passenger passenger);
	Passenger fetchPassengerInfo(Integer id);
}
