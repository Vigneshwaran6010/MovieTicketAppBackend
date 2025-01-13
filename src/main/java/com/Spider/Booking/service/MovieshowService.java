package com.Spider.Booking.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.MovieshowDao;
import com.Spider.Booking.dto.Movieshow;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.*;
import com.Spider.Booking.execption.ShowNotFoundException;
//import com.project.movieticketbooking.exception.ShowNotFoundException;

@Service
public class MovieshowService {
	@Autowired
	MovieshowDao movieshowDao;
	public ResponseEntity<ResponseStructure<Movieshow>> saveShow(Movieshow movieshow) {
		ResponseStructure<Movieshow> sturcture = new ResponseStructure<Movieshow>();
		sturcture.setData(movieshowDao.saveShow(movieshow));
		sturcture.setMessage("Show saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Movieshow>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Movieshow>> findShowById(int MovieshowId) {
		Movieshow foundShow = movieshowDao.findById(MovieshowId);
		if (foundShow != null) {
			ResponseStructure<Movieshow> sturcture = new ResponseStructure<Movieshow>();
			sturcture.setData(foundShow);
			sturcture.setMessage("Show found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(sturcture,HttpStatus.FOUND);
		}
		throw new ShowNotFoundException("Show Detail Not Found For A Given Id");
	}
	
	public ResponseEntity<ResponseStructure<Movieshow>> updateShow(int MovieshowId, Movieshow Show) {
		Movieshow Showa = movieshowDao.updateShow(MovieshowId, Show);
		if (Showa != null) {
			ResponseStructure<Movieshow> sturcture = new ResponseStructure<Movieshow>();
			sturcture.setData(Showa);
			sturcture.setMessage("Show updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(sturcture,HttpStatus.OK);

		}
		throw new ShowNotFoundException("Show Not Available For A Given Id");
	}

	public ResponseEntity<ResponseStructure<Movieshow>> deleteShow(int MovieshowId) {
		Movieshow Showaa = movieshowDao.deleteShow(MovieshowId);
		if (Showaa != null) {

			ResponseStructure<Movieshow> sturcture = new ResponseStructure<Movieshow>();
			sturcture.setData(Showaa);
			sturcture.setMessage("Show deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Movieshow>>(sturcture,HttpStatus.OK);

		
	}
		throw new ShowNotFoundException("For A Given Id Show Not Present"); 
}
	public ResponseEntity<ResponseStructure<List<Movieshow>>> findAllShow() {
		List<Movieshow> allFoundedBooking = movieshowDao.findAllShow();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Movieshow>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Movieshow>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfShowNotFoundException("Show's Details Not Found");
	}
}
