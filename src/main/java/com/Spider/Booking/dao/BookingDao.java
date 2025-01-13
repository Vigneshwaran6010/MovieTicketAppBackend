package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Spider.Booking.dto.Booking;
import com.Spider.Booking.repository.BookingRepository;

@Repository
public class BookingDao {
	@Autowired
	BookingRepository bookrepos;
	
	public Booking saveBooking(Booking booking) {
		return bookrepos.save(booking);
	}
	
	public Booking findById(int bookingId) {
		  Optional<Booking>book= bookrepos.findById(bookingId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Booking updateBooking(int bookingId,Booking booking) {
		Booking book=findById(bookingId);
		if (book!=null) {
			book.setBookingId(bookingId);
			return bookrepos.save(booking);
		}
		return null;
	}
	
	
	public Booking deleteBooking(int bookingId) {
		Booking book=findById(bookingId);
		if (book!=null) {
			bookrepos.delete(book);
			return book;}
		return null;
	}
	
	public List <Booking> findAllBooking(){
		return bookrepos.findAll();
	}

}
