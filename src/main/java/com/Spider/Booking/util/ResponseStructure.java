package com.Spider.Booking.util;
import lombok.Data;
@Data
public class ResponseStructure<T> {
	T Data;
	int status;
	String message;
	
	
	

}
