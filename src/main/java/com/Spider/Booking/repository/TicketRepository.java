package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
