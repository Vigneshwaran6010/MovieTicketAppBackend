package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer>{

}
