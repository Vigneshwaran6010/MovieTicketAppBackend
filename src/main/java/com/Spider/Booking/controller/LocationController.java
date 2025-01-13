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
import com.Spider.Booking.dto.Location;
import com.Spider.Booking.service.LocationService;
import com.Spider.Booking.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("location")
public class LocationController {
	@Autowired
	LocationService locationService;
	
	
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Location>> saveLocation(@Valid @RequestBody Location Location) {
		return locationService.saveLocation(Location);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Location>> findLocationByID(@RequestParam int locationid) {
		return locationService.findLocationById(locationid);
	}

	@GetMapping("findAllLocation")
	public ResponseEntity<ResponseStructure<List<Location>>> findAllLocation() {
		return locationService.findAllLocation();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Location>> updateLocation(@RequestParam int locationid, @RequestBody Location Location) {
		return locationService.updateLocation(locationid, Location);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Location>> deleteLocation(@RequestParam int locationid) {
		return locationService.deleteLocation(locationid);
	}


}
