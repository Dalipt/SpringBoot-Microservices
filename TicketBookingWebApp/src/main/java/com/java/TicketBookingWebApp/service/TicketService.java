package com.java.TicketBookingWebApp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.java.TicketBookingWebApp.model.Passenger;
import com.java.TicketBookingWebApp.model.Ticket;
@Service
public class TicketService implements ITicketService {

	private String url="http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticketnumber";
	private String get_url="http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticket/{ticketNumber}";
	@Override
	public Integer registerPassenger(Passenger passenger)
	{
		// Rest tempelate and webclients
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Integer> response = restTemplate.postForEntity(url, passenger, Integer.class);
		Integer ticketNumber = response.getBody();
		return ticketNumber;
	}

	@Override
	public Ticket getFullTicket(Integer ticketNumber) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Ticket>response=restTemplate.getForEntity(get_url, Ticket.class,ticketNumber);
		Ticket ticket = response.getBody();
		return ticket;
	}

}
