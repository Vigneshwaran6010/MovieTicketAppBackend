package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.LocationDao;
import com.Spider.Booking.dto.Location;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.ListOfLocationNotFoundException;
import com.Spider.Booking.execption.LocationNotFoundException;

@Service
public class LocationService {
	@Autowired
	LocationDao loacationdao;
	

	public ResponseEntity<ResponseStructure<Location>> saveLocation(Location Location) {
		ResponseStructure<Location> sturcture = new ResponseStructure<Location>();
		sturcture.setData(loacationdao.saveLocation(Location));
		sturcture.setMessage("Location saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Location>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Location>> findLocationById(int locationId) {
		Location foundLocation = loacationdao.findById(locationId);
		if (foundLocation != null) {
			ResponseStructure<Location> sturcture = new ResponseStructure<Location>();
			sturcture.setData(foundLocation);
			sturcture.setMessage("Location found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Location>>(sturcture,HttpStatus.FOUND);
		}
		throw new LocationNotFoundException("For A Given Id Location Not Found");
	}

	public ResponseEntity<ResponseStructure<Location>> updateLocation(int locationId, Location Location) {
		Location Locationa = loacationdao.updateLocation(locationId, Location);
		if (Locationa != null) {
			ResponseStructure<Location> sturcture = new ResponseStructure<Location>();
			sturcture.setData(Locationa);
			sturcture.setMessage("Location updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Location>>(sturcture,HttpStatus.OK);

		}
		throw new LocationNotFoundException("For A Given Id Location Is Not Present");
	}

	public ResponseEntity<ResponseStructure<Location>> deleteLocation(int locationId) {
		Location Locationaa = loacationdao.deleteLocation(locationId);
		if (Locationaa != null) {

			ResponseStructure<Location> sturcture = new ResponseStructure<Location>();
			sturcture.setData(Locationaa);
			sturcture.setMessage("Location deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Location>>(sturcture,HttpStatus.OK);

		
	}
		throw new LocationNotFoundException("Location Not Present For A Given Id");
}
	public ResponseEntity<ResponseStructure<List<Location>>> findAllLocation() {
		List<Location> allFoundedBooking = loacationdao.findAllLocation();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Location>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Location>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfLocationNotFoundException("Location Details Not Found"); // exception will be there if list of Booking object is null
	}
}
