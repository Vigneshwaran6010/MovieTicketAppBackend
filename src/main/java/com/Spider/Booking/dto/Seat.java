package com.Spider.Booking.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	private int screenId;
	private int seatNumber;

}
