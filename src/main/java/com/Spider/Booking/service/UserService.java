package com.Spider.Booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Spider.Booking.dao.UserDao;
import com.Spider.Booking.dto.User;
import com.Spider.Booking.execption.AdminNotFoundException;
import com.Spider.Booking.util.ResponseStructure;
import com.Spider.Booking.execption.ListOfAllUserNotFoundException;
import com.Spider.Booking.execption.UserNotFoundException;
@Service
public class UserService {
@Autowired
	UserDao userdao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User User) {
		ResponseStructure<User> sturcture = new ResponseStructure<User>();
		sturcture.setData(userdao.saveUser(User));
		sturcture.setMessage("User saved success");
		sturcture.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(sturcture,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<com.Spider.Booking.extra.UserDto >> findUserById(int userId) {
		com.Spider.Booking.extra.UserDto foundUser = userdao.findById(userId);
		if (foundUser != null) {
			ResponseStructure<com.Spider.Booking.extra.UserDto> sturcture = new ResponseStructure<>();
			sturcture.setData(foundUser);
			sturcture.setMessage("User found success");
			sturcture.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<com.Spider.Booking.extra.UserDto>>(sturcture,HttpStatus.FOUND);
		}
		throw new UserNotFoundException("For A Given Id User Is Not Present");
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int userId, User User) {
		User Usera = userdao.updateUser(userId, User);
		if (Usera != null) {
			ResponseStructure<User> sturcture = new ResponseStructure<User>();
			sturcture.setData(Usera);
			sturcture.setMessage("User updated");
			sturcture.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(sturcture,HttpStatus.OK);

		}
		throw new UserNotFoundException("For Given Id User Data Not Found :)");
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int userid) {
		ResponseEntity<ResponseStructure<com.Spider.Booking.extra.UserDto>> foundedUser = findUserById(userid);
		if (foundedUser != null) {
			ResponseStructure<User> structure = new ResponseStructure<>();
			User user = userdao.deleteUser(userid);
			structure.setData(user);
			structure.setMessage("User Deleted Successfull");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new UserNotFoundException("For A given Id Data Is Not Present"); // exception will be there if object is
																				// not present
	}
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
	List<User> allFoundedBooking = userdao.findAllUser();
	if (allFoundedBooking != null) {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(allFoundedBooking);
		structure.setMessage("All Booking Founded Successfull");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.NOT_FOUND);
	}
	throw new ListOfAllUserNotFoundException("No Users Not Found");// exception will be there if list of Booking object is null
}
public ResponseEntity<ResponseStructure<User>>UserLogin(String userEmail,String userpassword ){
	User user= userdao.findByEmail(userEmail);
	if(user!=null) {
		if(user.getUserPassword().equals(userpassword)) {
			ResponseStructure<User>structure=new ResponseStructure<>();
			structure.setData(user);
			structure.setMessage("User Founded Successfull");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException("User Email Or Admin Password Mismatch");
	}
	throw new UserNotFoundException("For a Given Email User Not Found");

		}
	
}

