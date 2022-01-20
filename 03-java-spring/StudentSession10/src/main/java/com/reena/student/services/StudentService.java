package com.reena.User.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.User.models.Project;
import com.reena.User.models.User;
import com.reena.User.repositories.ProjectRepository;
import com.reena.User.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository UserRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	

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
	
	// One User Detail
		public User findUser(Long id) {
			return UserRepo.findById(id).orElse(null);
		}

	
//	Like
	public void like(User User, Project project) {
		project.getLikers().add(User);
		projectRepo.save(project);
	
	}
//unlike
	public void Unlike(User User, Project project) {
		project.getLikers().remove(User);
		projectRepo.save(project);
	
	}
	
	
	
	

}
