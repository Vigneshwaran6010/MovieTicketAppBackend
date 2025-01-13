package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
