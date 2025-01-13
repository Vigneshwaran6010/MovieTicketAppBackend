package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Location;
import com.Spider.Booking.repository.LocationRepository;
@Repository
public class LocationDao {
	@Autowired
	LocationRepository locationRepo;
	public Location saveLocation(Location Location) {
		return locationRepo.save(Location);
	}
	
	public Location findById(int locationId) {
		  Optional<Location>book= locationRepo.findById(locationId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Location updateLocation(int locationId,Location Location) {
		Location book=findById(locationId);
		if (book!=null) {
			book.setLocationId(locationId);
			return locationRepo.save(Location);
		}
		return null;
	}
	
	
	public Location deleteLocation(int locationId) {
		Location book=findById(locationId);
		if (book!=null) {
			locationRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Location> findAllLocation(){
		return locationRepo.findAll();
	}

	
	
}
