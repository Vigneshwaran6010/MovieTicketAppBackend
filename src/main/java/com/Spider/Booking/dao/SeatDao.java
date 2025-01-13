package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Seat;
import com.Spider.Booking.repository.SeatRepository;
@Repository
public class SeatDao {
	@Autowired
	SeatRepository SeatRepo; 
	public Seat saveSeat(Seat Seat) {
		return SeatRepo.save(Seat);
	}
	
	public Seat findById(int seatId) {
		  Optional<Seat>book= SeatRepo.findById(seatId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Seat updateSeat(int seatId,Seat Seat) {
		Seat book=findById(seatId);
		if (book!=null) {
			book.setSeatId(seatId);
			return SeatRepo.save(Seat);
		}
		return null;
	}
	
	
	public Seat deleteSeat(int seatId) {
		Seat book=findById(seatId);
		if (book!=null) {
			SeatRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Seat> findAllSeat(){
		return SeatRepo.findAll();
	}

}
