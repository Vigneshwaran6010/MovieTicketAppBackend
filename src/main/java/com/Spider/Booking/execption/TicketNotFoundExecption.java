package com.Spider.Booking.execption;

public class TicketNotFoundExecption  extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;

public TicketNotFoundExecption(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

}
