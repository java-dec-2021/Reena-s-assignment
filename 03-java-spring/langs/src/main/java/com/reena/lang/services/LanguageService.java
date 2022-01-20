package com.reena.lang.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reena.lang.models.Language;
import com.reena.lang.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	@Autowired
	private LanguageRepository langRepo;

//	public UserService(UserRepository UserRepo) {
//		this.UserRepo = UserRepo;
//	}
	
//	Get me all languages 
	public List<Language> getAllLanguages(){
		return this.langRepo.findAll();
	}
	
//Create Language 
	public Language create(Language myLang) {
		return this.langRepo.save(myLang);
	}
	
//Update Language
	public Language update(Language myLang) {
		return this.langRepo.save(myLang);
	}
	
//Delete User 
	
	
	
	

}
