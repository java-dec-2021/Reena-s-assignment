package com.reena.student.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.reena.student.models.Project;
import com.reena.student.models.Student;
import com.reena.student.services.ProjectService;
import com.reena.student.services.StudentService;


@Controller
public class HomeController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newStudent") Student student) {
		return "index.jsp";
	}
	
//	Create student
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("newStudent") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			 this.studentService.create(student);
			 return "redirect:/dashboard";
		}
		
	}
//	Get All students 
	@GetMapping("/dashboard")
	public String students(Model model) {
		model.addAttribute("students",this.studentService.getAllStudents());
		return "dashboard.jsp";
	}
	
//	Delete a student 
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.studentService.deleteStudent(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/welcome")
	public String welcome(@RequestParam("firstName") String fName,
			@RequestParam("email") String email,
			@RequestParam("program") String program,
			Model studentModel,
			HttpSession mySession
			) {
		studentModel.addAttribute("firstName",fName);
		studentModel.addAttribute("email",email);
		studentModel.addAttribute("program",program);
		
		mySession.setAttribute("firstName", fName);
		return "welcome.jsp";
		
		
	}
	@GetMapping("/details")
	public String details(HttpSession mySession) {
//		mySession.invalidate();
		return "details.jsp";
	}
	
//	Login
	@PostMapping("/login/{id}")
	public String login(@PathVariable("id")Long id, HttpSession session) {
		session.setAttribute("student_id", id);
		return "redirect:/projects";
	}
//	Like 
	@GetMapping("/like/{project_id}")
	public String like(@PathVariable("project_id") Long project_id, HttpSession session) {
		Long student_id= (Long)session.getAttribute("student_id");
		Student student=studentService.findStudent(student_id);
		Project project=projectService.findProject(project_id);
		
		studentService.like(student, project);
		return "redirect:/projects";
		
	}
	
//	UnLike 
	@GetMapping("/unLike/{project_id}")
	public String Unlike(@PathVariable("project_id") Long project_id, HttpSession session) {
		Long student_id= (Long)session.getAttribute("student_id");
		Student student=studentService.findStudent(student_id);
		Project project=projectService.findProject(project_id);
		
		studentService.Unlike(student, project);
		return "redirect:/projects";
		
	}
}



