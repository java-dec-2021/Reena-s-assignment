package com.reena.User.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.User.models.User;
import com.reena.User.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepo;

//	public UserService(UserRepository UserRepo) {
//		this.UserRepo = UserRepo;
//	}
	
//	Get me all Users 
	public List<User> getAllUsers(){
		return this.UserRepo.findAll();
	}
	
//Create User 
	public User create(User myUser) {
		return this.UserRepo.save(myUser);
	}
	
//Update User
//Delete User 
	public void deleteUser(Long id) {
		this.UserRepo.deleteById(id);
	}
	
	
	
	

}
