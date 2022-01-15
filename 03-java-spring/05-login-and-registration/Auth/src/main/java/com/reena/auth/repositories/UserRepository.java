package com.reena.auth.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.auth.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	 User findByEmail(String email);
	

}
