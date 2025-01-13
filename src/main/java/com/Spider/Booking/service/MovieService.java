package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.MovieDao;
import com.Spider.Booking.dto.Movie;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.ListOfMoviesNotFoundException;
import com.Spider.Booking.execption.MovieNotFoundException;

@Service
public class MovieService {
	@Autowired
	
	MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie Movie) {
		ResponseStructure<Movie> sturcture = new ResponseStructure<Movie>();
		sturcture.setData(movieDao.saveMovie(Movie));
		sturcture.setMessage("Movie saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Movie>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Movie>> findMovieById(int movieId) {
		Movie foundMovie = movieDao.findById(movieId);
		if (foundMovie != null) {
			ResponseStructure<Movie> sturcture = new ResponseStructure<Movie>();
			sturcture.setData(foundMovie);
			sturcture.setMessage("Movie found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Movie>>(sturcture,HttpStatus.FOUND);
		}
		throw new MovieNotFoundException("Movie Not Present For A Given Id");
	}

	public ResponseEntity<ResponseStructure<Movie>> updateMovie(int movieId, Movie Movie) {
		Movie Moviea = movieDao.updateMovie(movieId, Movie);
		if (Moviea != null) {
			ResponseStructure<Movie> sturcture = new ResponseStructure<Movie>();
			sturcture.setData(Moviea);
			sturcture.setMessage("Movie updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movie>>(sturcture,HttpStatus.OK);

		}
		throw new MovieNotFoundException("For A Given Id Movie Not Found");
	}

	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId) {
		Movie Movieaa = movieDao.deleteMovie(movieId);
		if (Movieaa != null) {

			ResponseStructure<Movie> sturcture = new ResponseStructure<Movie>();
			sturcture.setData(Movieaa);
			sturcture.setMessage("Movie deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movie>>(sturcture,HttpStatus.OK);

		
	}
		throw new MovieNotFoundException("For Given Id Data Is Not Present So You Can't Able To Delete"); 
}
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
		List<Movie> allFoundedBooking = movieDao.findAllMovie();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Movie>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Movie>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfMoviesNotFoundException("Movie's Details Not Found"); // exception will be there if list of Booking object is null
	}



}
