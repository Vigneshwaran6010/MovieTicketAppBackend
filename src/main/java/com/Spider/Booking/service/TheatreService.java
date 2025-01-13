package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.TheatreDao;
import com.Spider.Booking.dto.Theatre;
import com.Spider.Booking.execption.ListOfTheatreNotFoundException;
import com.Spider.Booking.execption.TheatreNotFoundExecption;
import com.Spider.Booking.util.ResponseStructure;

@Service
public class TheatreService {
	@Autowired
	TheatreDao theatredao;

	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre Theatre) {
		ResponseStructure<Theatre> sturcture = new ResponseStructure<Theatre>();
		sturcture.setData(theatredao.saveTheatre(Theatre));
		sturcture.setMessage("Theatre saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Theatre>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Theatre>> findTheatreById(int theatreId) {
		Theatre foundTheatre = theatredao.findById(theatreId);
		if (foundTheatre != null) {
			ResponseStructure<Theatre> sturcture = new ResponseStructure<Theatre>();
			sturcture.setData(foundTheatre);
			sturcture.setMessage("Theatre found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(sturcture,HttpStatus.FOUND);
		}
		throw new TheatreNotFoundExecption("Theatre not found for this id");
	}

	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(int theatreId, Theatre Theatre) {
		Theatre Theatrea = theatredao.updateTheatre(theatreId, Theatre);
		if (Theatrea != null) {
			ResponseStructure<Theatre> sturcture = new ResponseStructure<Theatre>();
			sturcture.setData(Theatrea);
			sturcture.setMessage("Theatre updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(sturcture,HttpStatus.OK);

		}
		throw new TheatreNotFoundExecption("theater data can't be updated");
	}

	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId) {
		Theatre Theatreaa = theatredao.deleteTheatre(theatreId);
		if (Theatreaa != null) {

			ResponseStructure<Theatre> sturcture = new ResponseStructure<Theatre>();
			sturcture.setData(Theatreaa);
			sturcture.setMessage("Theatre deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Theatre>>(sturcture,HttpStatus.OK);

		
	}
		throw new TheatreNotFoundExecption("theater data can't be Deleted");
}
	public ResponseEntity<ResponseStructure<List<Theatre>>> findAllTheatre() {
		List<Theatre> allFoundedBooking = theatredao.findAllTheatre();
		if (allFoundedBooking != null) {
			ResponseStructure<List<Theatre>> structure = new ResponseStructure<>();
			structure.setData(allFoundedBooking);
			structure.setMessage("All Booking Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Theatre>>>(structure, HttpStatus.NOT_FOUND);
		}
		 throw new ListOfTheatreNotFoundException("list of theatre can't be found"); // exception will be there if list of Booking object is null
	}
}
