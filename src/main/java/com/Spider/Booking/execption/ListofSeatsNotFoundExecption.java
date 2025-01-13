package com.Spider.Booking.execption;
public class ListofSeatsNotFoundExecption  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ListofSeatsNotFoundExecption(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
