package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Spider.Booking.dao.SeatDao;
import com.Spider.Booking.dto.Seat;
import com.Spider.Booking.execption.ListofSeatsNotFoundExecption;
import com.Spider.Booking.execption.SeatNotFoundException;
import com.Spider.Booking.util.ResponseStructure;

@Service
public class SeatService {
	@Autowired
	SeatDao seatDao;
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat Seat) {
		ResponseStructure<Seat> sturcture = new ResponseStructure<Seat>();
		sturcture.setData(seatDao.saveSeat(Seat));
		sturcture.setMessage("Seat saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Seat>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Seat>> findSeatById(int seatId) {
		Seat foundSeat = seatDao.findById(seatId);
		if (foundSeat != null) {
			ResponseStructure<Seat> sturcture = new ResponseStructure<Seat>();
			sturcture.setData(foundSeat);
			sturcture.setMessage("Seat found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Seat>>(sturcture,HttpStatus.FOUND);
		}
		throw new SeatNotFoundException("Seat not found for this id");
	}

	public ResponseEntity<ResponseStructure<Seat>> updateSeat(int seatId, Seat Seat) {
		Seat Seata = seatDao.updateSeat(seatId, Seat);
		if (Seata != null) {
			ResponseStructure<Seat> sturcture = new ResponseStructure<Seat>();
			sturcture.setData(Seata);
			sturcture.setMessage("Seat updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Seat>>(sturcture,HttpStatus.OK);

		}
		throw new SeatNotFoundException("Seat not found for this id");
	}

	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int seatId) {
		Seat Seataa = seatDao.deleteSeat(seatId);
		if (Seataa != null) {

			ResponseStructure<Seat> sturcture = new ResponseStructure<Seat>();
			sturcture.setData(Seataa);
			sturcture.setMessage("Seat deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Seat>>(sturcture,HttpStatus.OK);

		
	}
		throw new SeatNotFoundException("Seat not found for the id");
		
}	
	public ResponseEntity<ResponseStructure<List<Seat>>> findAllSeat() {
		List<Seat> allFoundedBooking = seatDao.findAllSeat();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Seat>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Seat>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListofSeatsNotFoundExecption("list of seats not found execption"); // exception will be there if list of Booking object is null
	}
}
