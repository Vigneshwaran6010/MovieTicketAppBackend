package com.Spider.Booking.execption;



public class LocationNotFoundException extends RuntimeException {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;

public LocationNotFoundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}


}
