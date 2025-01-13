package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Spider.Booking.dto.Admin;
import com.Spider.Booking.extra.Admindto;
import com.Spider.Booking.repository.AdminRepository;

@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	ModelMapper modelmapper;

	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}

	public Admindto findById(int adminId) {
		Optional<Admin> book = adminRepo.findById(adminId);
		if (book.isPresent()) {
			return modelmapper.map(book.get(), Admindto.class);
		}
		return null;
	}

	public Admin updateAdmin(int adminId, Admin admin) {
		Admindto book = findById(adminId);
		if (book != null) {
			book.setAdminId(adminId);
			return admin;
		}
		return null;
	}

	public Admin deleteAdmin(int adminId) {
		Optional<Admin> foundedAdmin = adminRepo.findById(null);
		if (foundedAdmin != null) {
			adminRepo.delete(foundedAdmin.get());
			return foundedAdmin.get();
		}
		return null; // exception will be there for object is not present
	}

	public List<Admin> findAllAdmin() {
		return adminRepo.findAll();
	}

	public Admin findByEmail(String adminEmail) {
		Admin Admin = adminRepo.findByAdminEmail(adminEmail);
		if (Admin != null) {
			return Admin;
		}
		return null;
	}

	public Admin AdminLogin(String adminEmail, String adminPassword) {
		Admin admin = adminRepo.findByAdminEmail(adminEmail);
		if (admin != null) {
			if (admin.getAdminPassword().equals(adminPassword)) {
				return admin;
			}
			return null;
		}
		return null;
	}

}
