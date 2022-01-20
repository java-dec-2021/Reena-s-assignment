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
import org.springframework.web.bind.annotation.RequestParam;

import com.reena.User.models.Project;
import com.reena.User.models.User;
import com.reena.User.services.ProjectService;
import com.reena.User.services.UserService;


@Controller
public class HomeController {
	@Autowired
	private UserService UserService;
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("newUser") User User) {
		return "index.jsp";
	}
	
//	Create User
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("newUser") User User, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			 this.UserService.create(User);
			 return "redirect:/dashboard";
		}
		
	}
//	Get All Users 
	@GetMapping("/dashboard")
	public String Users(Model model) {
		model.addAttribute("Users",this.UserService.getAllUsers());
		return "dashboard.jsp";
	}
	
//	Delete a User 
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.UserService.deleteUser(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/welcome")
	public String welcome(@RequestParam("firstName") String fName,
			@RequestParam("email") String email,
			@RequestParam("program") String program,
			Model UserModel,
			HttpSession mySession
			) {
		UserModel.addAttribute("firstName",fName);
		UserModel.addAttribute("email",email);
		UserModel.addAttribute("program",program);
		
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
		session.setAttribute("User_id", id);
		return "redirect:/projects";
	}
//	Like 
	@GetMapping("/like/{project_id}")
	public String like(@PathVariable("project_id") Long project_id, HttpSession session) {
		Long User_id= (Long)session.getAttribute("User_id");
		User User=UserService.findUser(User_id);
		Project project=projectService.findProject(project_id);
		
		UserService.like(User, project);
		return "redirect:/projects";
		
	}
	
//	UnLike 
	@GetMapping("/unLike/{project_id}")
	public String Unlike(@PathVariable("project_id") Long project_id, HttpSession session) {
		Long User_id= (Long)session.getAttribute("User_id");
		User User=UserService.findUser(User_id);
		Project project=projectService.findProject(project_id);
		
		UserService.Unlike(User, project);
		return "redirect:/projects";
		
	}
}



