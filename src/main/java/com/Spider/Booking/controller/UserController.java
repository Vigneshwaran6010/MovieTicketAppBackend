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
import com.Spider.Booking.dto.User;
import com.Spider.Booking.extra.UserDto;
import com.Spider.Booking.service.UserService;
import com.Spider.Booking.util.ResponseStructure;
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser( @RequestBody User User) {
		return userService.saveUser(User);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<UserDto>> findUserByID(@RequestParam int userId) {
		return userService.findUserById(userId);
	}

	@GetMapping("findAllUser")
	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		return userService.findAllUser();
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int userId, @RequestBody User User) {
		return userService.updateUser(userId, User);
	}

	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int userId) {
		return userService.deleteUser(userId);
	}
	@GetMapping("userLogin")
	public ResponseEntity<ResponseStructure<User>> Userlogin(String userEmail, String userPassword) {
		return userService.UserLogin(userEmail, userPassword);
	}


}
