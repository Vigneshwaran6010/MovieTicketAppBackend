package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.ScreenDao;
import com.Spider.Booking.dto.Screen;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.ListOfScreenNotFoundException;
import com.Spider.Booking.execption.ScreenNotFoundException;

@Service
public class ScreenService {
	@Autowired
	ScreenDao screenDao;
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen Screen) {
		ResponseStructure<Screen> sturcture = new ResponseStructure<Screen>();
		sturcture.setData(screenDao.saveScreen(Screen));
		sturcture.setMessage("Screen saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Screen>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Screen>> findScreenById(int ScreenId) {
		Screen foundScreen = screenDao.findById(ScreenId);
		if (foundScreen != null) {
			ResponseStructure<Screen> sturcture = new ResponseStructure<Screen>();
			sturcture.setData(foundScreen);
			sturcture.setMessage("Screen found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Screen>>(sturcture,HttpStatus.FOUND);
		}
		throw new ScreenNotFoundException("Screen is not found for the given id");
	}

	public ResponseEntity<ResponseStructure<Screen>> updateScreen(int ScreenId, Screen Screen) {
		Screen Screena = screenDao.updateScreen(ScreenId, Screen);
		if (Screena != null) {
			ResponseStructure<Screen> sturcture = new ResponseStructure<Screen>();
			sturcture.setData(Screena);
			sturcture.setMessage("Screen updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Screen>>(sturcture,HttpStatus.OK);

		}
		throw new ScreenNotFoundException ("Screen not updated for this id");
	}

	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int ScreenId) {
		Screen Screenaa = screenDao.deleteScreen(ScreenId);
		if (Screenaa != null) {

			ResponseStructure<Screen> sturcture = new ResponseStructure<Screen>();
			sturcture.setData(Screenaa);
			sturcture.setMessage("Screen deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Screen>>(sturcture,HttpStatus.OK);

		
	}
		throw new ScreenNotFoundException("Couldn't Find A Screen Data For A Given Id");
}

	public ResponseEntity<ResponseStructure<List<Screen>>> findAllScreen() {
		List<Screen> allFoundedBooking = screenDao.findAllScreen();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Screen>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Screen>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfScreenNotFoundException("Screen's Details Not Found"); // exception will be there if list of Booking object is null
	}
}
