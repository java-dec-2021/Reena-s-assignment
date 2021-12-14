package com.reena.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String hello() {
		return "index.jsp";
	}
	
	@RequestMapping("/java")
	public String welcome(Model model) {
		model.addAttribute("firstName","Caleb");
		model.addAttribute("language","Java");
		return "index.jsp";
	}
	
	@RequestMapping("/welcome")
	public String welcomeUer(@RequestParam(value="n", required = false) String firstName, Model model) {
		model.addAttribute("firstName",firstName);
		return "index.jsp";
	}
	
	
	
	
	

	
}
