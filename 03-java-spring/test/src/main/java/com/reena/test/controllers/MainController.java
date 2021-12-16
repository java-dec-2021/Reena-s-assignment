package com.reena.test.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@PostMapping("/welcome")
	public String dashboard(@RequestParam("firstName") String firstName,
			@RequestParam("email") String email,
			@RequestParam("program") String program,
			Model viewModel,
			HttpSession mySession) {
		viewModel.addAttribute("firstName", firstName);
		viewModel.addAttribute("email", email);
		viewModel.addAttribute("program", program);
		mySession.setAttribute("firstName", firstName);
		return "dashboard.jsp";
	}
	@GetMapping("/details")
	public String details() {
		return "details.jsp";
	}

}
