package com.Spider.Booking.dao;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Spider.Booking.dto.User;
import com.Spider.Booking.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository UserRepo;
	@Autowired
	ModelMapper modelmapper;

	public User saveUser(User User) {
		return UserRepo.save(User);
	}

	public com.Spider.Booking.extra.UserDto findById(int userId) {
		Optional<User> book = UserRepo.findById(userId);
		if (book.isPresent()) {
			return modelmapper.map(book.get(), com.Spider.Booking.extra.UserDto.class);
		}
		return null;
	}

	public User updateUser(int userId, User User) {
		com.Spider.Booking.extra.UserDto book = findById(userId);
		if (book != null) {
			book.setUserId(userId);
			return UserRepo.save(User);
		}
		return null;
	}

	public User deleteUser(int UserId) {
		Optional<User> findedUser = UserRepo.findById(UserId);
		if (findedUser.isPresent()) {
			UserRepo.delete(findedUser.get());
			return findedUser.get();
		}
		return null; // exception will be there for object is not present
	}

	public List<User> findAllUser() {
		return UserRepo.findAll();
	}

//	6. find user by  email return User
	public User findByEmail(String userEmail) {
		User user = UserRepo.findByuserEmail(userEmail);
		if (user != null) {
			return user;
		}
		return null;
	}

//	7.user login validation for email and password
	public User userLogin(String userEmail, String userPassword) {
		User user = UserRepo.findByuserEmail(userEmail);
		if (user != null) {
			if (user.getUserPassword().equals(userPassword)) {
				return user;
			}
			return null;
		}
		return null;
	}
}
