package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Movieshow;
import com.Spider.Booking.repository.MovieshowRepository;
@Repository
public class MovieshowDao {
	@Autowired
	MovieshowRepository MovieshowRepo;

	public Movieshow saveShow(Movieshow movieshow) {
		return MovieshowRepo.save(movieshow);
	}
	
	public Movieshow findById(int MovieshowId) {
		  Optional<Movieshow>book= MovieshowRepo.findById(MovieshowId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Movieshow updateShow(int MovieshowId,Movieshow movieshow) {
		Movieshow book=findById(MovieshowId);
		if (book!=null) {
			book.setMovieshowId(MovieshowId);
			return MovieshowRepo.save(movieshow);
		}
		return null;
	}
	
	
	public Movieshow deleteShow(int MovieshowId) {
		Movieshow book=findById(MovieshowId);
		if (book!=null) {
			MovieshowRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Movieshow> findAllShow(){
		return MovieshowRepo.findAll();
	}
}
