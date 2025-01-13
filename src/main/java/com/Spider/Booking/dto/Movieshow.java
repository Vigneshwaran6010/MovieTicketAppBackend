package com.Spider.Booking.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Movieshow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int MovieshowId;
	private int movieId;
	private int screenId;
	private String showTiming;

}
