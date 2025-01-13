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
import com.Spider.Booking.dto.Seat;
import com.Spider.Booking.service.SeatService;
import com.Spider.Booking.util.ResponseStructure;
@RestController
@RequestMapping("seat")
public class SeatController {
	@Autowired
	SeatService seatService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Seat>> saveSeat( @RequestBody Seat Seat) {
		return seatService.saveSeat(Seat);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Seat>> findSeatByID(@RequestParam int seatId) {
		return seatService.findSeatById(seatId);
	}

	@GetMapping("findAllSeat")
	public ResponseEntity<ResponseStructure<List<Seat>>> findAllSeat() {
		return seatService.findAllSeat();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(@RequestParam int seatId, @RequestBody Seat Seat) {
		return seatService.updateSeat(seatId, Seat);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(@RequestParam int seatId) {
		return seatService.deleteSeat(seatId);
	}


}
