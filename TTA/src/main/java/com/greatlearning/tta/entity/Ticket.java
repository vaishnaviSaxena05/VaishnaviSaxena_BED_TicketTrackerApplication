package com.greatlearning.tta.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", ticketTitle=" + ticketTitle + ", ticketShortDescription="
				+ ticketShortDescription + ", ticketCreated=" + ticketCreated + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column(name ="ticket_title")
	private String ticketTitle;
	@Column(name="ticket_Short_Description")
	private String ticketShortDescription;
	@Column(name="ticket_Created")
	private Date ticketCreated;
	
	public Ticket() {
		//this.ticketTitle="<ENTER YOUR FIRST NAME>";
	}
    
	public Ticket( String ticketTitle, String ticketShortDescription, Date ticketCreated) {
		
		this.ticketTitle = ticketTitle;
		this.ticketShortDescription = ticketShortDescription;
		this.ticketCreated = ticketCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketShortDescription() {
		return ticketShortDescription;
	}

	public void setTicketShortDescription(String ticketShortDescription) {
		this.ticketShortDescription = ticketShortDescription;
	}

	public Date getTicketCreated() {
		return ticketCreated;
	}

	public void setTicketCreated(Date ticketCreated) {
		this.ticketCreated = ticketCreated;
	}


	
	
	
}
