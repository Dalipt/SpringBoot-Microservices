package com.java.TicketBookingWebApp.service;

import com.java.TicketBookingWebApp.model.Passenger;
import com.java.TicketBookingWebApp.model.Ticket;

public interface ITicketService 
{
	public Integer registerPassenger(Passenger passenger);
	public Ticket getFullTicket(Integer ticketNumber);

}
