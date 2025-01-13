package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer > {

}
