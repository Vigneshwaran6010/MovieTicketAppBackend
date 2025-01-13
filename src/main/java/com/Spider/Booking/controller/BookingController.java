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
import com.Spider.Booking.dto.Booking;
import com.Spider.Booking.service.BookingService;
import com.Spider.Booking.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("booking")
public class BookingController {
	@Autowired
	BookingService bookingservice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@Valid @RequestBody Booking Booking) {
		return bookingservice.saveBooking(Booking);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBookingByID(@RequestParam int bookingId) {
		return bookingservice.findBookingById(bookingId);
	}

	@GetMapping("findAllBooking")
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		return bookingservice.findAllBooking();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestParam int bookingId, @RequestBody Booking Booking) {
		return bookingservice.updateBooking(bookingId, Booking);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingId) {
		return bookingservice.deleteBooking(bookingId);
	}

	
	

}
