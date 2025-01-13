package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.dto.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
