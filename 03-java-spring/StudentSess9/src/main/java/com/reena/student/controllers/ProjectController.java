package com.reena.student.controllers;


import java.util.List;

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

import com.reena.student.models.Project;
import com.reena.student.models.Student;
import com.reena.student.services.ProjectService;
import com.reena.student.services.StudentService;



@Controller
public class ProjectController {
	@Autowired
	private StudentService sService;
	
	@Autowired
	private ProjectService pService;
	
//	List All Projects 
	@GetMapping("/projects")
	public String allProjects(Model model) {
		List<Project> allProjects=pService.allProjects();
		model.addAttribute("allProjects",allProjects);
		return "/projects/projects.jsp";
	}
	
//Create a new project 
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project project, Model model) 	{
	List<Student> allStudents=this.sService.getAllStudents();
		model.addAttribute("allStudents",allStudents);
		return "/projects/new.jsp";
	}
	
	@PostMapping("/projects/create")
	public String create(@ModelAttribute("newProject") Project project) {
		this.pService.createProject(project);
		return "redirect:/projects";
		
		
	}

//	Login
	@GetMapping("/projects/login/{id}")
	public String login(@PathVariable("id") Long id, HttpSession session ) {
		session.setAttribute("userId", id);
		return "redirect:/projects"; 
	}
	
	@GetMapping("/projectDetails/{id}")
	public String details(@PathVariable("id") Long id, HttpSession session, Model model) {
		model.addAttribute(pService.findProject(id));
		session.setAttribute("userId", id);
		return "projects/project.jsp"; 
	}
	
  // Delete a student 
	@DeleteMapping("project/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.pService.deleteProject(id);
		return "redirect:/projects";
	}
	
	//Edit a project 
	  @GetMapping("/projects/edit/{id}")
		public String edit(@PathVariable("id") Long id, Model model,@ModelAttribute("editedProject") Project project) {
		  model.addAttribute("editProject",pService.findProject(id));
		  System.out.print("jdsjf");
		  return "/projects/edit.jsp";
		}
	  
	  //Update student Info
	  @PutMapping("/projects/update/{id}")
	  public String update(@Valid @ModelAttribute("editedProject") Project project, BindingResult result,@PathVariable("id") Long id, Model model) {
		  if(result.hasErrors()) {
			  model.addAttribute("editProject",pService.findProject(id));
				return "/projects/edit.jsp";
			} 
			else { 
				
			pService.updateProject(project);
			return "redirect:/projects";
			}
	  }
	
	
		
	
//  Like
	/*
	 * @GetMapping("/projects/like/{id}") public String like(@PathVariable("id")
	 * Long id, HttpSession mysession) { // How do I like a project? Long
	 * studentId=(Long)mysession.getAttribute("userId"); Student
	 * student=sService.findStudent(studentId); Project
	 * project=pService.findProject(id); pService.AddLikes(project, student); return
	 * "redirect:/projects"; }
	 */

}
