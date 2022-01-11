package com.reena.lang.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reena.lang.models.Language;
import com.reena.lang.services.LanguageService;


@Controller
public class HomeController {

	@Autowired
	private LanguageService langService;
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("newLang") Language language, Model model) {
		model.addAttribute("languages",langService.getAllLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("newLang") Language language, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("languages",langService.getAllLanguages());
			return "index.jsp";
		}
		else {
			 this.langService.create(language);
			 return "redirect:/languages";
		}
		
	}

	
	
	

}
