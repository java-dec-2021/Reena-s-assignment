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
	
	//One Student Detail	
			public Student findStudent(Long id) {
				return studentRepo.findById(id).orElse(null);
			}

	
//Update Student
	public Student updateStudent(Student updateStudent) {
		System.out.print("this is updating");
		return this.studentRepo.save(updateStudent);
		
	}
	
//Delete Student 
	public void deleteStudent(Long id) {
		this.studentRepo.deleteById(id);
	}
	
	

	
	

}
