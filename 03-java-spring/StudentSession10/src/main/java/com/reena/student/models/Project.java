package com.reena.User.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	@Size(min = 3, max = 20, message = "Project Name should be between 3-20 chars")
	private String projectName;
	
	@Size(min = 2, max = 40, message = "description between 2-400 chars")
	private String description;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="User_id")
	    private User User;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
		        name = "likes", 
		        joinColumns = @JoinColumn(name = "project_id"), 
		        inverseJoinColumns = @JoinColumn(name = "User_id")
		    )
	 private List<User> likers; 
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return User;
	}

	public void setUser(User User) {
		this.User = User;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}
	 
	 
	
	

}
