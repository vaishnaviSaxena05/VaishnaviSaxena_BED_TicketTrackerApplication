package com.greatlearning.tta.service;

import java.util.List;

import com.greatlearning.tta.entity.Ticket;

public interface TicketService {

	// list of ticket
	List<Ticket> listTickets();
	//create of new ticket 
	Ticket saveTicket(Ticket ticket);
	
	//edit of ticket 
	Ticket editTicket(Ticket ticket);
	//edit by id 
  Ticket getTicketById(Integer id);
   //delete by id 
  void deleteById(Integer id);
	
  /*Ticket searchById(Integer id);*/
  
  public List<Ticket> getAllTickets();
  
  
 // for search button
  public List<Ticket> getByKeyword(String keyword);
  
  
}
