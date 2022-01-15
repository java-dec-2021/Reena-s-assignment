package com.reena.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reena.student.models.Student;
import com.reena.student.services.StudentService;

@RestController
public class APIController {
	@Autowired
	private StudentService studentService;
	

	@GetMapping("/api/students")
	public List<Student> students() {
		return this.studentService.getAllStudents();
	}
	
	@PostMapping("/api/create")
	public Student create(Student myStudent) {
		return this.studentService.create(myStudent);
	}

}
