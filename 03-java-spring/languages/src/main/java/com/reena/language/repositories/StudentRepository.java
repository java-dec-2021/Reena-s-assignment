package com.reena.language.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.language.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

//	Get list of students 
	List<Student> findAll();
}
