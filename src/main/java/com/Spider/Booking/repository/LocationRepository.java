package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
