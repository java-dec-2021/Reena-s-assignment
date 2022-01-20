package com.reena.User.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reena.User.models.User;
import com.reena.User.services.UserService;

@RestController
public class APIController {
	@Autowired
	private UserService UserService;
	

	@GetMapping("/api/Users")
	public List<User> Users() {
		return this.UserService.getAllUsers();
	}
	
	@PostMapping("/api/create")
	public User create(User myUser) {
		return this.UserService.create(myUser);
	}

}
