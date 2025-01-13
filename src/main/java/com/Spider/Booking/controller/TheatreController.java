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
import com.Spider.Booking.dto.Theatre;
import com.Spider.Booking.service.TheatreService;
import com.Spider.Booking.util.ResponseStructure;
import jakarta.validation.Valid;
@RestController
@RequestMapping("theatre")
public class TheatreController {
	@Autowired
	TheatreService theatreService;
	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(@Valid @RequestBody Theatre Theatre) {
		return theatreService.saveTheatre(Theatre);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatreByID(@RequestParam int theatreId) {
		return theatreService.findTheatreById(theatreId);
	}

	@GetMapping("findAllTheatre")
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		return theatreService.findAllTheatre();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(@RequestParam int theatreId, @RequestBody Theatre Theatre) {
		return theatreService.updateTheatre(theatreId, Theatre);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(@RequestParam int theatreId) {
		return theatreService.deleteTheatre(theatreId);
	}


}
