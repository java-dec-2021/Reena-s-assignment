package com.reena.student.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.reena.student.models.Project;
import com.reena.student.services.ProjectService;
import com.reena.student.services.StudentService;


@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@GetMapping("/projects")
	public String projects(Model model) {
		model.addAttribute("projects",projectService.allProjects());
		return "/projects/projects.jsp";
	}
	
//	Create Project 
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project project, Model model) {
		model.addAttribute("allStudents",studentService.getAllStudents());
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
	  @GetMapping("/projectDetails/{id}")
	  public String projectDetails(@PathVariable("id") Long id, Model model) {
		  model.addAttribute("project",projectService.findProject(id));
		  return "/projects/project.jsp";
		  
	  }
	  
//	  Edit Project 
	  @GetMapping("/projects/edit/{id}")
	  public String edit(@PathVariable("id") Long id,Model model, @ModelAttribute("editedProject") Project project) {
		  model.addAttribute("editProject",projectService.findProject(id));
		  return "/projects/edit.jsp";
		  
	  }
	  
//	  Update Project 
	  @PostMapping("/projects/update/{id}")
	  public String updateProject(@Valid @ModelAttribute("editedProject") Project project, BindingResult
			  result, @PathVariable("id") Long id, Model model) 
			  { 
				  if(result.hasErrors()) 
				  {  model.addAttribute("editProject",projectService.findProject(id));
					  return "/projects/edit.jsp"; 
				} 
				  else {
					  System.out.println(project.getId());
					  	this.projectService.updateProject(project);
					  	return "redirect:/projects"; }
			  }
	  
	 


}
