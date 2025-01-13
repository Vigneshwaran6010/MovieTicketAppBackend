package com.Spider.Booking.execption;


public class listOfTicketNotFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public String getMessage() {
		return message;
	}

	public listOfTicketNotFound(String message) {
		super();
		this.message = message;
	}
	

}
