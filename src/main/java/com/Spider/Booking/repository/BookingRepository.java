package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer > {

}
