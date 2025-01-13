package com.Spider.Booking.execption;

public class BookingUpdateCannotDone  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	public BookingUpdateCannotDone(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
