package com.Spider.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spider.Booking.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
public Admin findByAdminEmail(String AdminEmail);
}
