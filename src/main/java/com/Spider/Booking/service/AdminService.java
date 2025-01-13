package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.AdminDao;
import com.Spider.Booking.dto.Admin;
import com.Spider.Booking.execption.ListOfAdminNotFoundException;
import com.Spider.Booking.execption.AdminNotFoundException;
import com.Spider.Booking.extra.Admindto;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.UserNotFoundException;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> sturcture = new ResponseStructure<Admin>();
		sturcture.setData(adminDao.saveAdmin(admin));
		sturcture.setMessage("Admin saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Admindto>> findAdminById(int adminId) {
		Admindto foundAdmin = adminDao.findById(adminId);
		if (foundAdmin != null) {
			ResponseStructure<Admindto> sturcture = new ResponseStructure<>();
			sturcture.setData(foundAdmin);
			sturcture.setMessage("Admin found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Admindto>>(sturcture,HttpStatus.FOUND);
		}
		throw new AdminNotFoundException("Admin not present for this id");
	}

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(int adminId, Admin admin) {
		Admin Admina = adminDao.updateAdmin(adminId, admin);
		if (Admina != null) {
			ResponseStructure<Admin> sturcture = new ResponseStructure<Admin>();
			sturcture.setData(Admina);
			sturcture.setMessage("Admin updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(sturcture,HttpStatus.OK);

		}
		throw new AdminNotFoundException("Admin can't updatedfor this id");
	}

	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int adminId) {
		
		ResponseEntity<ResponseStructure<Admindto>> Adminaa = findAdminById(adminId);
		if (Adminaa != null) {

			ResponseStructure<Admin> sturcture = new ResponseStructure<>();
			sturcture.setData(adminDao.deleteAdmin(adminId));
			sturcture.setMessage("Admin deleted");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(sturcture,HttpStatus.OK);

		
	}
	 throw new AdminNotFoundException("Admin not present for this id");
}
	public ResponseEntity<ResponseStructure<List<Admin>>> findAllAdmin() {
		List<Admin> allFoundedAdmin = adminDao.findAllAdmin();
		if (allFoundedAdmin != null) {
			ResponseStructure<List<Admin>> structure = new ResponseStructure<>();
			structure.setData(allFoundedAdmin);
			structure.setMessage("All Admin Founded Successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Admin>>>(structure, HttpStatus.NOT_FOUND);
		}
		throw new ListOfAdminNotFoundException("Admin's Details Not Found"); // exception will be there if list of Admin object is null
	}
	
//	6.find by email return admin
			public ResponseEntity<ResponseStructure<Admin>> findByEmailAdmin(String adminEmail) {
				Admin Admin = adminDao.findByEmail(adminEmail);
				if (Admin != null) {
					ResponseStructure<Admin> structure = new ResponseStructure<>();
					structure.setData(Admin);
					structure.setMessage("Admin Founded Successfull");
					structure.setStatus(HttpStatus.OK.value());
					return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
				}
				throw new AdminNotFoundException("For a given Email Admin Not Found");

			}

//8.admin login validation for email and password
			public ResponseEntity<ResponseStructure<Admin>> AdminLogin(String adminEmail, String adminPassword) {
				Admin Admin = adminDao.findByEmail(adminEmail);
				if (Admin != null) {
					if (Admin.getAdminPassword().equals(adminPassword)) {
						ResponseStructure<Admin> structure = new ResponseStructure<>();
						structure.setData(Admin);
						structure.setMessage("Admin Founded Successfull");
						structure.setStatus(HttpStatus.OK.value());
						return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
					}
					throw new AdminNotFoundException("User Email Or Admin Password Mismatch");
				}
				throw new UserNotFoundException("For a Given Email User Not Found");
			}

}
