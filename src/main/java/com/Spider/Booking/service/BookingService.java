package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.BookingDao;
import com.Spider.Booking.dto.Booking;
import com.Spider.Booking.util.ResponseStructure;

import com.Spider.Booking.execption.BookingDeleteNotFound;
import com.Spider.Booking.execption.BookingNotFoundException;
import com.Spider.Booking.execption.BookingUpdateCannotDone;
import com.Spider.Booking.execption.ListOfBookingNotFoundException;

@Service
public class BookingService {
	@Autowired
	BookingDao Book;
	
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking) {
		ResponseStructure<Booking> sturcture = new ResponseStructure<Booking>();
		sturcture.setData(Book.saveBooking(booking));
		sturcture.setMessage("Booking saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Booking>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Booking>> findBookingById(int bookingId) {
		Booking foundBooking = Book.findById(bookingId);
		if (foundBooking != null) {
			ResponseStructure<Booking> sturcture = new ResponseStructure<Booking>();
			sturcture.setData(foundBooking);
			sturcture.setMessage("Booking found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Booking>>(sturcture,HttpStatus.FOUND);
		}
		throw new BookingNotFoundException("For The Given Id Booking Details Not Found or Booking Id is Invalid");
	}

	public ResponseEntity<ResponseStructure<Booking>> updateBooking(int bookingId, Booking Booking) {
		Booking Bookinga = Book.updateBooking(bookingId, Booking);
		if (Bookinga != null) {
			ResponseStructure<Booking> sturcture = new ResponseStructure<Booking>();
			sturcture.setData(Bookinga);
			sturcture.setMessage("Booking updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Booking>>(sturcture,HttpStatus.OK);

		}
		throw new BookingUpdateCannotDone("For The Given Id Data Not Present or else Booking Details Not Retrieved");
	}

	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingId) {
		Booking Bookingaa = Book.deleteBooking(bookingId);
		if (Bookingaa != null) {

			ResponseStructure<Booking> sturcture = new ResponseStructure<Booking>();
			sturcture.setData(Bookingaa);
			sturcture.setMessage("Booking deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Booking>>(sturcture,HttpStatus.OK);

		
	}
		throw new BookingDeleteNotFound("For The Given Id Booking Details Not Found"); 
}
	
	public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
		List<Booking> allFoundedBooking = Book.findAllBooking();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Booking>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Booking>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfBookingNotFoundException("No Booking Details Found it Should Be Empty");  // exception will be there if list of Booking object is null
	}
	}
