package com.reena.lang.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reena.lang.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {

//	Get list of students 
	List<Language> findAll();
}
