package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.TicketDao;
import com.Spider.Booking.dto.Ticket;
import com.Spider.Booking.execption.TicketNotFoundExecption;
import com.Spider.Booking.execption.listOfTicketNotFound;
import com.Spider.Booking.util.ResponseStructure;

@Service
public class TicketService {
	@Autowired
	TicketDao ticketDao;

	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket Ticket) {
		ResponseStructure<Ticket> sturcture = new ResponseStructure<Ticket>();
		sturcture.setData(ticketDao.saveTicket(Ticket));
		sturcture.setMessage("Ticket saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Ticket>>(sturcture, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Ticket>> findTicketById(int ticketId) {
		Ticket foundTicket = ticketDao.findById(ticketId);
		if (foundTicket != null) {
			ResponseStructure<Ticket> sturcture = new ResponseStructure<Ticket>();
			sturcture.setData(foundTicket);
			sturcture.setMessage("Ticket found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(sturcture, HttpStatus.FOUND);
		}
		throw new TicketNotFoundExecption("theatre cant be found");
	}

	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(int ticketId, Ticket Ticket) {
		Ticket Ticketa = ticketDao.updateTicket(ticketId, Ticket);
		if (Ticketa != null) {
			ResponseStructure<Ticket> sturcture = new ResponseStructure<Ticket>();
			sturcture.setData(Ticketa);
			sturcture.setMessage("Ticket updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(sturcture, HttpStatus.OK);

		}
		throw new TicketNotFoundExecption("theatre cant be updated");
	}

	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int ticketId) {
		Ticket Ticketaa = ticketDao.deleteTicket(ticketId);
		if (Ticketaa != null) {
			ResponseStructure<Ticket> sturcture = new ResponseStructure<Ticket>();
			sturcture.setData(Ticketaa);
			sturcture.setMessage("Ticket deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Ticket>>(sturcture, HttpStatus.OK);
		}
		throw new TicketNotFoundExecption("ticket cant be deleted");
	}

	public ResponseEntity<ResponseStructure<List<Ticket>>> findAllTicket() {
		List<Ticket> allFoundedBooking = ticketDao.findAllTicket();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Ticket>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Ticket>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new listOfTicketNotFound("List of Ticket not found");// exception will be there if list of Booking object
																	// is null
	}
}
