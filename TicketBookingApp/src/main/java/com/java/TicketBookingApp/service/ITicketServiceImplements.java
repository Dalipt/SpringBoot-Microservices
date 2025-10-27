package com.java.TicketBookingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.TicketBookingApp.model.Passenger;
import com.java.TicketBookingApp.repo.ITicketRepo;

@Service
public class ITicketServiceImplements implements ITicketService {

	@Autowired
	public ITicketRepo repo;
	@Override
	public Passenger registerPassanger(Passenger passenger)
	{
		return repo.save(passenger);
	}

	@Override
	public Passenger fetchPassengerInfo(Integer id)
	{
		Optional<Passenger>optional=repo.findById(id);
		
		return optional.get();
	}

}
