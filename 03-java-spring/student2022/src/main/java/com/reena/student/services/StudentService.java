package com.reena.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.student.models.Student;
import com.reena.student.repositories.StudentRepository;

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
	public void deleteStudent(Long id) {
		this.studentRepo.deleteById(id);
	}
	
	
	
	

}
