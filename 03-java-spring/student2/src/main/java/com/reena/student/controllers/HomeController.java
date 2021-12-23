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

import com.reena.student.models.Student;
import com.reena.student.services.StudentService;


@Controller
public class HomeController {
	@Autowired
	private StudentService studentService;

	
//	@RequestMapping("/")
	@GetMapping("/")
	public String index(@ModelAttribute("newStudent") Student newStudent) {
		return "index.jsp";
	}
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("newStudent") Student newStudent,BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} 
		else { 
		
		 this.studentService.create(newStudent);
		 return "redirect:/dashboard";
		}
		
	}
	
	//	List All the students
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "dashboard.jsp";
		
	}
//	Delete a Student
	@DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
        return "redirect:/dashboard";
    }
	
//	@RequestMapping(path="/welcome", method=RequestMethod.POST)
	@PostMapping("/welcome")
	public String welcome(@RequestParam("firstName") String firstName,
			@RequestParam("email") String email,
			@RequestParam("lastName") String lastName,
			Model studentModel,
			HttpSession mySession
			) {
		studentModel.addAttribute("firstName",firstName);
		studentModel.addAttribute("lastName",lastName);
		studentModel.addAttribute("email",email);
		
		mySession.setAttribute("firstName", firstName);
		return "welcome.jsp";
		
		
	}
	@GetMapping("/details")
	public String details(HttpSession mySession) {
//		mySession.invalidate();
		return "details.jsp";
	}

}
