package com.reena.student.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="students")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotNull
	@Size(min = 3, max = 20, message = "First Name should be between 3-20 chars")
	private String firstName;
	
	@Size(min = 2, max = 40, message = "Last Name should be between 2-40 chars")
	private String lastName;
	
	@NotNull
	@Email(message = "Do you even know what email address look like??")
	private String email;
	
	 @OneToMany(mappedBy="student", fetch = FetchType.LAZY)
	 private List<Project> projects;
	
   //Getters and Setters
	public Long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
