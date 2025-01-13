package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.Screen;
import com.Spider.Booking.repository.ScreenRepository;
@Repository
public class ScreenDao {
	@Autowired
	ScreenRepository ScreenRepo;
	
	public Screen saveScreen(Screen Screen) {
		return ScreenRepo.save(Screen);
	}
	
	public Screen findById(int screenId) {
		  Optional<Screen>book= ScreenRepo.findById(screenId);
		  if(book.isPresent()) {
			  return book.get();
		  }
		  return null;}
	
	public Screen updateScreen(int screenId,Screen Screen) {
		Screen book=findById(screenId);
		if (book!=null) {
			book.setScreenId(screenId);
			return ScreenRepo.save(Screen);
		}
		return null;
	}
	
	
	public Screen deleteScreen(int screenId) {
		Screen book=findById(screenId);
		if (book!=null) {
			ScreenRepo.delete(book);
			return book;}
		return null;
	}
	
	public List <Screen> findAllScreen(){
		return ScreenRepo.findAll();
	}

}
