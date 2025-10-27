package com.java.TicketBookingApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.TicketBookingApp.model.Passenger;
import com.java.TicketBookingApp.model.Ticket;
import com.java.TicketBookingApp.service.ITicketService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/book-ticket")
@Tag(name="TicketBookingAPI", description="There are two API one will accept passenger info and another will generate ticket info based on ticket number")
public class TicketController 
{
	@Autowired
	private ITicketService service;
	
	@PostMapping("/get-ticketnumber")
	@Operation(summary="Post operation",description="This api will accept passenger info and generate ticket number ")
	public ResponseEntity<Integer>registerPassenger(@RequestBody Passenger passenger)
	{
		Passenger pass=service.registerPassanger(passenger);
		Integer ticket=pass.getPid();
		return new ResponseEntity<Integer>(ticket, HttpStatus.CREATED);
	}
	@GetMapping("/get-ticket/{ticketNumber}")
	@Operation(summary="Post operation",description="This api will accept ticket number and generate fullticket  ")
	public ResponseEntity<Ticket>getTicket(@PathVariable("ticketNumber")Integer ticketNumber)
	{
		Passenger passenger=service.fetchPassengerInfo(ticketNumber);
		Ticket ticket= new Ticket();
		ticket.setTicketNumber(passenger.getPid());
		ticket.setName(passenger.getName());
		ticket.setDeparture(passenger.getDeparture());
		ticket.setArrival(passenger.getArrival());
		ticket.setDateOfJourney(passenger.getDateOfJourney());
		ticket.setStatus("Confirmend");
		ticket.setTicketPrice(5353.43);

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
		
	}
}
