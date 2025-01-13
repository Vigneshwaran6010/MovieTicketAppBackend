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
import com.Spider.Booking.dto.Screen;
import com.Spider.Booking.service.ScreenService;
import com.Spider.Booking.util.ResponseStructure;
import jakarta.validation.Valid;
@RestController
@RequestMapping("screen")
public class ScreenController {
	@Autowired
	ScreenService screenService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(@Valid @RequestBody Screen Screen) {
		return screenService.saveScreen(Screen);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Screen>> findScreenByID(@RequestParam int screenId) {
		return screenService.findScreenById(screenId);
	}

	@GetMapping("findAllScreen")
	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen() {
		return screenService.findAllScreen();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(@RequestParam int screenId, @RequestBody Screen Screen) {
		return screenService.updateScreen(screenId, Screen);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(@RequestParam int screenId) {
		return screenService.deleteScreen(screenId);
	}

}
