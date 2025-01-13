package com.Spider.Booking.util;

public class ResponseStructure<T> {
	T Data;
	int status;
	String message;
	public T getData() {
		return Data;
	}
	public void setData(T data) {
		Data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseStructure(T data, int status, String message) {
		super();
		Data = data;
		this.status = status;
		this.message = message;
	}
	public ResponseStructure() {
		super();
	}
	@Override
	public String toString() {
		return "ResponseStructure [Data=" + Data + ", status=" + status + ", message=" + message + "]";
	}
	

}
