package com.Spider.Booking.dto;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId;
	private String screenName;
	private long noOfSeats;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Theatre>theatres;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Movieshow>movieshow;
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Seat>seat;

}
