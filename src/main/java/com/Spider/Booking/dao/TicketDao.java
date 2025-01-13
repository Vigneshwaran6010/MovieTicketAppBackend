package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Ticket;
import com.Spider.Booking.repository.TicketRepository;
@Repository
public class TicketDao {
	@Autowired
	TicketRepository TicketRepo;
	public Ticket saveTicket(Ticket Ticket) {
		return TicketRepo.save(Ticket);
	}
	
	public Ticket findById(int ticketId) {
		  Optional<Ticket>book= TicketRepo.findById(ticketId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Ticket updateTicket(int ticketId,Ticket Ticket) {
		Ticket book=findById(ticketId);
		if (book!=null) {
			book.setTicketId(ticketId);
			return TicketRepo.save(Ticket);
		}
		return null;
	}
	
	
	public Ticket deleteTicket(int TicketId) {
		Ticket book=findById(TicketId);
		if (book!=null) {
			TicketRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Ticket> findAllTicket(){
		return TicketRepo.findAll();
	}
}
