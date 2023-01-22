package com.greatlearning.tta.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import java.util.List;
import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;

@Service
public  class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;
	public TicketServiceImpl(TicketRepository ticketRepository) {
		this.ticketRepository=ticketRepository;
	}

	@Override
	public List<Ticket> listTickets() {

		return ticketRepository.findAll();
		
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket editTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Integer id) {
		
		return ticketRepository.findById(id).get();
	}

	@Override
	public void deleteById(Integer id) {
		
		ticketRepository.deleteById(id);
		
	}

	@Override
	public List<Ticket> getAllTickets() {
		 List<Ticket> tickets =  (List<Ticket>)ticketRepository.findAll();
		  return tickets;
	}

	@Override
	public List<Ticket> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		  return ticketRepository.findByKeyword(keyword);
	}

	





}
