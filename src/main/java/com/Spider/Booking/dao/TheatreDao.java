package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Theatre;
import com.Spider.Booking.repository.TheatreRepository;
@Repository
public class TheatreDao {
	@Autowired
	TheatreRepository TheatreRepo;

	public Theatre saveTheatre(Theatre Theatre) {
		return TheatreRepo.save(Theatre);
	}
	
	public Theatre findById(int theatreId) {
		  Optional<Theatre>book= TheatreRepo.findById(theatreId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Theatre updateTheatre(int theatreId,Theatre Theatre) {
		Theatre book=findById(theatreId);
		if (book!=null) {
			book.setTheatreId(theatreId);
			return TheatreRepo.save(Theatre);
		}
		return null;
	}
	
	
	public Theatre deleteTheatre(int theatreId) {
		Theatre book=findById(theatreId);
		if (book!=null) {
			TheatreRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Theatre> findAllTheatre(){
		return TheatreRepo.findAll();
	}
}
