/**
 * 
 */
package com.reena.daikichi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author reena
 *
 */
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("firstName","Reena");
		model.addAttribute("stack","Java");
		return "index.jsp";
	}
	
	@RequestMapping("/daikkichi")
	public String daikkichi() {
		return "You are having a luck day!";
	}
	
	@RequestMapping("/welcome")
	public String Welcome(@RequestParam(value="q", required = false) String firstName) {
		if(firstName==null) {
			return "You are having a luck day" ;
		}
		else {
		return "You are having a luck day " + firstName ;
		}
	}
	
	@RequestMapping("/daikkichi/travel/{place}")
	public String travel(@PathVariable("place") String place) {
		return "Congratulations you won tickets to " + place;
	}
	
	
	
}
