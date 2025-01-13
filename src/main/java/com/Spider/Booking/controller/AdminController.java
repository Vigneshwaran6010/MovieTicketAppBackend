package com.Spider.Booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Spider.Booking.dto.Admin;
import com.Spider.Booking.extra.Admindto;
import com.Spider.Booking.service.AdminService;
import com.Spider.Booking.util.ResponseStructure;
@RestController
@RequestMapping("admin")
public class AdminController {
	@Autowired
	AdminService AdminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin( @RequestBody Admin admin) {
		return AdminService.saveAdmin(admin);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Admindto>> findAdminByID(@RequestParam int adminId) {
		return AdminService.findAdminById(adminId);
	}

	@GetMapping("findAllAdmin")
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
		return AdminService.findAllAdmin();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestParam int adminId, @RequestBody Admin admin) {
		return AdminService.updateAdmin(adminId, admin);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int adminId) {
		return AdminService.deleteAdmin(adminId);
	}
	@GetMapping("adminLogin")
	public ResponseEntity<ResponseStructure<Admin>> AdminLogin(String adminEmail, String adminPassword) {
		return AdminService.AdminLogin(adminEmail, adminPassword);
	}
}
