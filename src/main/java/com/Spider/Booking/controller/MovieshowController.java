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
import com.Spider.Booking.dto.Movieshow;
import com.Spider.Booking.service.MovieshowService;
import com.Spider.Booking.util.ResponseStructure;
import jakarta.validation.Valid;
@RestController
@RequestMapping("movieShow")
public class MovieshowController {
	@Autowired
	MovieshowService movieshowService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Movieshow>> saveShow(@Valid @RequestBody Movieshow movieshow) {
		return movieshowService.saveShow(movieshow);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Movieshow>> findShowByID(@RequestParam int MovieshowId) {
		return movieshowService.findShowById(MovieshowId);
	}

	@GetMapping("findAllShow")
	public ResponseEntity<ResponseStructure<List<Movieshow>>> findAllShow() {
		return movieshowService.findAllShow();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Movieshow>> updateShow(@RequestParam int MovieshowId, @RequestBody Movieshow movieshow) {
		return movieshowService.updateShow(MovieshowId, movieshow);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movieshow>> deleteShow(@RequestParam int MovieshowId) {
		return movieshowService.deleteShow(MovieshowId);
	}


}
