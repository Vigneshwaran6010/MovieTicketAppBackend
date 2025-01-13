package com.Spider.Booking.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Movie;
import com.Spider.Booking.repository.MovieRepository;
@Repository
public class MovieDao {
	@Autowired
	MovieRepository movieRepo;

	public Movie saveMovie(Movie Movie) {
		return movieRepo.save(Movie);
	}
	
	public Movie findById(int movieId) {
		  Optional<Movie>book= movieRepo.findById(movieId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Movie updateMovie(int movieId,Movie Movie) {
		Movie book=findById(movieId);
		if (book!=null) {
			book.setMovieId(movieId);
			return movieRepo.save(Movie);
		}
		return null;
	}
	
	
	public Movie deleteMovie(int movieId) {
		Movie book=findById(movieId);
		if (book!=null) {
			movieRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Movie> findAllMovie(){
		return movieRepo.findAll();
	}

}
