package com.reena.User.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.reena.student.services.ProjectService;
import com.reena.student.services.UserService;


@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService UserService;
	
	
	
	
	@GetMapping("/projects")
	public String projects(Model model, HttpSession session) {
		model.addAttribute("projects",projectService.allProjects());
		Long id= (Long)session.getAttribute("User_id");
	    User User= UserService.findUser(id);
	    model.addAttribute("loggedInUser",User);
		return "/projects/projects.jsp";
	}
	
//	Create Project 
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project project, Model model) {
		model.addAttribute("allUsers",UserService.getAllUsers());
		return "/projects/new.jsp";
	}
	
//	Create Project
	  @PostMapping("/projects/create") 
	  public String createProject(@Valid @ModelAttribute("newProject") Project project, BindingResult
	  result) 
	  { 
		  if(result.hasErrors()) 
		  { 
			  return "projects.jsp"; } 
		  else {
			  	this.projectService.createProject(project);
			  	return "redirect:/projects"; }
	  }
	  
//	  Get Project Details 
	  @GetMapping("/projectDetails/{Myid}")
	  public String projectDetails(@PathVariable("Myid") Long projectId, Model model) {
		  model.addAttribute("project",projectService.findProject(projectId));
		  return "/projects/project.jsp";
		  
	  }
	  
//	  Edit Project 
	  @GetMapping("/projects/edit/{id}")
	  public String edit(@PathVariable("id") Long id,Model model) {
		  model.addAttribute("editProject",projectService.findProject(id));
		  return "/projects/edit.jsp";
		  
	  }
	  
//	  Update Project 
	  @PutMapping("/projects/update/{id}")
	  public String updateProject(@Valid @ModelAttribute("editProject") Project project, BindingResult
			  result, @PathVariable("id") Long id, Model model) 
			  { 
				  if(result.hasErrors()) 
				  {  model.addAttribute("editProject",projectService.findProject(id));
					  return "/projects/edit.jsp"; 
				} 
				  else {
					  	this.projectService.updateProject(project);
					  	return "redirect:/projects"; }
			  }
	  
	  
//
	  @DeleteMapping("/projects/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			this.projectService.deleteProject(id);
			return "redirect:/projects";
		}
	 


}
