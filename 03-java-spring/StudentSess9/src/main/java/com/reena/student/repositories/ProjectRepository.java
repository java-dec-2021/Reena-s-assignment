package com.reena.User.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.User.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

//	Get list of projects 
	  List<Project> findAll();
	  
}

