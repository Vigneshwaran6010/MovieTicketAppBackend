package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
public User findByuserEmail(String userEmail);
}
