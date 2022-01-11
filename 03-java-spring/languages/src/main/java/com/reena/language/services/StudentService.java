package com.reena.language.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.language.models.Student;
import com.reena.language.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

//	public StudentService(StudentRepository studentRepo) {
//		this.studentRepo = studentRepo;
//	}
	
//	Get me all students 
	public List<Student> getAllStudents(){
		return this.studentRepo.findAll();
	}
	
//Create Student 
	public Student create(Student myStudent) {
		return this.studentRepo.save(myStudent);
	}
	
//Update Student
//Delete Student 
	
	
	
	

}
