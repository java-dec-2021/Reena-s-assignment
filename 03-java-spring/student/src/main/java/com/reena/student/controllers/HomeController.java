package com.reena.User.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	
//	@RequestMapping("/")
	@GetMapping("/")
	public String index(Model model) {
		String[] programs= {"Java","MERN","MEAN"};
		model.addAttribute("programs",programs);
		return "index.jsp";
	}
	
//	@RequestMapping(path="/welcome", method=RequestMethod.POST)
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

}
