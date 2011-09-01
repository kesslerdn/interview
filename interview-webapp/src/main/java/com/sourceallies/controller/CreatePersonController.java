package com.sourceallies.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sourceallies.dao.PersonDao;
import com.sourceallies.model.Person;

@Controller
@RequestMapping("/person/create.do")
public class CreatePersonController{
	
	@Resource(name="person")
	Person person;
	
	@Resource(name="personDao")
	PersonDao personDao;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelMap setupForm() {
        return new ModelMap("person", person);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public void create(@Valid Person person, BindingResult result) {
		personDao.save(person);
    }

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
}