package com.reena.student.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.student.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

//	Get list of students 
	List<Project> findAll();
}
