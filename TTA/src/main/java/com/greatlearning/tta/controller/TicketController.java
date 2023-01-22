package com.greatlearning.tta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tta.entity.Ticket;
import com.greatlearning.tta.repository.TicketRepository;
import com.greatlearning.tta.service.TicketService;
import com.greatlearning.tta.service.impl.TicketServiceImpl;

@Controller
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	// this is for listing of tickets
	@GetMapping("/tickets")
	public String listTicket(Model model) {
		
		List<Ticket> tickets = ticketService.listTickets();

		model.addAttribute("tickets", tickets);
		return "tickets";
	}// end of listing of employee

	// this is for new tickets
	@GetMapping("/tickets/new")
	public String createNewTicketButtonClicked(Model model) {
		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);
	
		return "newTicket";
	}



	@PostMapping("/tickets") 
	public String submitButtonClickedForNewTicket(@ModelAttribute("ticket")Ticket ticket) 
	{
		
		ticketService.saveTicket(ticket);


		return "redirect:/tickets";

	}
	//end of new tickets



	//edit of ticket
	@GetMapping("/tickets/edit/{id}") 
	public String editTicketButtonClicked(@PathVariable Integer id, Model model) {
	 
		Ticket selectedTicket=ticketService.getTicketById(id);
		model.addAttribute("ticket",selectedTicket); 
		return "edit_Ticket";

	}



	@PostMapping("/tickets/{id}") 
	public String submitButtonClickedForEditTicket(@PathVariable Integer id,@ModelAttribute("ticket")Ticket ticket) {

		//Edit of ticket 
		Ticket exixtingTicket = ticketService.getTicketById(id);
		exixtingTicket.setTicketTitle(ticket.getTicketTitle());
		exixtingTicket.setTicketCreated(ticket.getTicketCreated());
		exixtingTicket.setTicketShortDescription(ticket.getTicketShortDescription());
		ticketService.editTicket(ticket);

		return "redirect:/tickets"; 
	}
	//end edit of ticket
	//start of Delete 
	@GetMapping("/tickets/{id}")
	public String deleteTicket(@PathVariable Integer id) {
		ticketService.deleteById(id);
		return "redirect:/tickets";
	}

	//end of delete button 

	//start of Search by title and short description 

	@GetMapping(path = {"/tickets/search"})
	 public String home(Ticket ticket, Model model, String keyword) {
	  if(keyword!=null) {
	   List<Ticket> list =ticketService.getByKeyword(keyword);
	   model.addAttribute("tickets", list);
	  }else {
	  List<Ticket> list = ticketService.getAllTickets();
	  model.addAttribute("tickets", list);}
	  return "tickets";
	 }





}
