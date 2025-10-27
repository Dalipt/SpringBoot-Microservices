package com.java.TicketBookingWebApp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.java.TicketBookingWebApp.model.Passenger;
import com.java.TicketBookingWebApp.model.Ticket;
@Service
public class TicketService implements ITicketService {

	private String url="http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticketnumber";
	private String get_url="http://localhost:8484/TicketBookingAPI/api/book-ticket/get-ticket/{ticketNumber}";
	@Override
	public Integer registerPassenger(Passenger passenger)
	{
		// Rest tempelate commented using webclients
		
		/*
		 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<Integer>
		 * response = restTemplate.postForEntity(url, passenger, Integer.class); Integer
		 * ticketNumber = response.getBody();
		 */
		WebClient webclient = WebClient.create();
		Integer ticketNumber = webclient.post()
		.uri(url)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(Integer.class)
		.block();	
		return ticketNumber;
	}

	@Override
	public Ticket getFullTicket(Integer ticketNumber) {
		/*
		 * RestTemplate restTemplate = new RestTemplate();
		 * 
		 * ResponseEntity<Ticket>response=restTemplate.getForEntity(get_url,
		 * Ticket.class,ticketNumber); Ticket ticket = response.getBody();
		 */
		WebClient webclient = WebClient.create();
		 Ticket ticket = webclient.get()
		.uri(get_url,ticketNumber)
		.retrieve()
		.bodyToMono(Ticket.class)
		.block();	
		return ticket;
	}

}
