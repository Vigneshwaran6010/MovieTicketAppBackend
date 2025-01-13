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
import com.Spider.Booking.dto.Movie;
import com.Spider.Booking.service.MovieService;
import com.Spider.Booking.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("movie")

public class MovieController {
	@Autowired
	MovieService movieService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(@Valid @RequestBody Movie Movie) {
		return movieService.saveMovie(Movie);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Movie>> findMovieByID(@RequestParam int MovieId) {
		return movieService.findMovieById(MovieId);
	}

	@GetMapping("findAllMovie")
	public ResponseEntity<ResponseStructure<List<Movie>>> findAllMovie() {
		return movieService.findAllMovie();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(@RequestParam int MovieId, @RequestBody Movie Movie) {
		return movieService.updateMovie(MovieId, Movie);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(@RequestParam int MovieId) {
		return movieService.deleteMovie(MovieId);
	}


}
