package com.Spider.Booking.execption;

public class ListOfAllUserNotFoundException  extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;
public ListOfAllUserNotFoundException(String message) {
	super();
	this.message = message;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getMessage() {
	return message;
}

}
