package com.java.TicketBookingWebApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.TicketBookingWebApp.model.Passenger;
import com.java.TicketBookingWebApp.model.Ticket;
import com.java.TicketBookingWebApp.service.ITicketService;

@Controller
public class TicketController
{
	@Autowired
	private ITicketService service;
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute Passenger passenger,Model model)
	{
		Integer ticketNumber=service.registerPassenger(passenger);
		model.addAttribute("ticketNumber",ticketNumber);
		return "index";//Logical view name
	}
	
	@GetMapping("/passenger-form")
	public String bookTicketfrom(@ModelAttribute Passenger passenger,Model model)
	{
		model.addAttribute("passenger",new Passenger());
		return "index";//Logical view name
	}

	@GetMapping("/ticket-form")
	public String Ticketform(@ModelAttribute Passenger passenger,Model model)
	{
		model.addAttribute("passenger",new Passenger());
		return "ticket-form";//Logical view name
	}
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam("ticketNumber") Integer ticketNumber, Model model)
	{
		Ticket ticket=service.getFullTicket(ticketNumber);
		model.addAttribute("ticket", ticket);
		return"ticket-info";
	}
}
