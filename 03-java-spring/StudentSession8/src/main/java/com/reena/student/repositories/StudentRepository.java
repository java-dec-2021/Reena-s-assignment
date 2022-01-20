package com.reena.User.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.User.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	Get list of Users 
	List<User> findAll();
}
