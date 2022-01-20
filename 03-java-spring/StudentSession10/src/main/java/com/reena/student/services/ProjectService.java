package com.reena.User.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.auth.models.Project;
import com.reena.student.repositories.ProjectRepository;



@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;

	// List all project
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}

	// Create Project
	public Project createProject(Project newProject) {
		return this.projectRepo.save(newProject);
	}

	// One Project Detail
	public Project findProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	// Update Project
	public Project updateProject(Project updateProject) {
		return this.projectRepo.save(updateProject);

	}

	// Delete Project
	public void deleteProject(Long id) {
		this.projectRepo.deleteById(id);
	}
	

}
