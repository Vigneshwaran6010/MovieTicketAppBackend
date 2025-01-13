package com.Spider.Booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Spider.Booking.dto.Ticket;
import com.Spider.Booking.service.TicketService;
import com.Spider.Booking.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("ticket")
public class TicketController {
	@Autowired
	TicketService ticketService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@Valid @RequestBody Ticket Ticket) {
		return ticketService.saveTicket(Ticket);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Ticket>> findTicketByID(@RequestParam int ticketId) {
		return ticketService.findTicketById(ticketId);
	}

	@GetMapping("findAllTicket")
	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
		return ticketService.findAllTicket();
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestParam int ticketId,
			@RequestBody Ticket Ticket) {
		return ticketService.updateTicket(ticketId, Ticket);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(@RequestParam int ticketId) {
		return ticketService.deleteTicket(ticketId);
	}

}
